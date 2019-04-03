package com.example.audiodb;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.audiodb.Adapters.AlbumAdapter;
import com.example.audiodb.Models.AlbumContainer;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SuppressWarnings("NullableProblems")
public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ImageButton scrollToTopBottom;
    RecyclerView recyclerView;
    AlbumAdapter albumAdapter;
    AlbumContainer albumContainer;
    HashMap<String, String> albumHashMap;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isNetworkAvailable()) {
            alertNoConnection();
        } else {
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }

        scrollToTopBottom = findViewById(R.id.scrollToTopBottom);
        progressBar = findViewById(R.id.progressBar);
        scrollToTopBottom.bringToFront();
        progressBar.bringToFront();
        albumHashMap = new HashMap<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                 @Override
                 public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                     super.onScrollStateChanged(recyclerView, newState);
                 }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    scrollToTopBottom.setImageResource(R.drawable.up);
                    scrollToTopBottom.setTag("UP");
                } else if (dy < 0){
                    scrollToTopBottom.setImageResource(R.drawable.down);
                    scrollToTopBottom.setTag("DOWN");
                } else {
                    scrollToTopBottom.setTag("STILL");
                }
            }
        });

        getAlbums("coldplay");

    }


    public void getAlbums(String artist) {
        String url = "https://theaudiodb.com/api/v1/json/1/searchalbum.php?s=" + artist;

        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("pogreska", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    String albums = response.body().string();
                    Log.d("response", albums);
                    String result = "";
                    try {
                        JSONObject jsonObject = new JSONObject(albums);
                        result = jsonObject.getString("album");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String finalResult = result;
                    runOnUiThread(() -> updateUI(albums, finalResult));
                }
            }
        });
    }

    private void updateUI(String albums, String finalResult) {
        Log.d("nulll", finalResult);
        Gson gson = new Gson();
        albumContainer = gson.fromJson(albums, AlbumContainer.class);

        if (albumContainer != null && !finalResult.equals("null")) {
            if (albumContainer.getAlbumSize() > 0) {
                //for(Album album: albumContainer.getAlbum()){
                //    albumHashMap.put(album.getIdAlbum(), album.getStrAlbum());
                //}
                setRecylerViewSmoothScrollListener(albumContainer.getAlbumSize());
                albumAdapter = new AlbumAdapter(MainActivity.this, albumContainer);
                recyclerView.setAdapter(albumAdapter);
                /*
                ItemTouchHelper.Callback callback = new ItemMoveCallback(albumAdapter);
                ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
                touchHelper.attachToRecyclerView(recyclerView);
                */
                progressBar.setVisibility(View.GONE);
                scrollToTopBottom.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
                Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.artist_not_found), Snackbar.LENGTH_LONG).show();
            }
        } else {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.artist_not_found), Snackbar.LENGTH_LONG).show();
        }

    }


    public void setRecylerViewSmoothScrollListener(Integer listSize) {
        scrollToTopBottom.setOnClickListener(v -> {
            if (scrollToTopBottom.getTag().equals("UP")) {
                recyclerView.smoothScrollToPosition(0);
            } else {
                recyclerView.smoothScrollToPosition(listSize);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_toolbar, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        if (menuItem != null) {
            final SearchView searchView = (SearchView) menuItem.getActionView();
            searchView.setOnCloseListener(() -> true);
            searchView.setOnSearchClickListener(v -> {
            });
            EditText searchEditText = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            searchEditText.setHint(getResources().getString(R.string.search_artist));
            View searchEditTextView = searchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
            searchEditTextView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    //Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    getAlbums(query);
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void alertNoConnection() {
        alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle(getResources().getString(R.string.no_internet_title))
                .setMessage(getResources().getString(R.string.no_internet_message))
                .setPositiveButton(getResources().getString(R.string.positive_button), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        startActivity(getIntent());
                    }
                })
                .show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!isNetworkAvailable()) {
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            alertNoConnection();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isNetworkAvailable()) {
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            alertNoConnection();
        } else {
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }
}
