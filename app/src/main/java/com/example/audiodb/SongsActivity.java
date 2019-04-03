package com.example.audiodb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.audiodb.Adapters.ItemMoveCallback;
import com.example.audiodb.Adapters.TracksAdapter;
import com.example.audiodb.Models.TracksContainer;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SongsActivity extends AppCompatActivity {

    TracksContainer tracksContainer;
    RecyclerView recyclerView;
    TracksAdapter tracksAdapter;
    ProgressBar progressBar;
    ImageButton scrollToTopBottom;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

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
        scrollToTopBottom.setVisibility(View.GONE);
        progressBar.bringToFront();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(SongsActivity.this));

        Intent intent = getIntent();
        String albumID = intent.getStringExtra("IDALBUM");
        if (albumID != null) {
            getTracks(albumID);
        }
    }


    public void getTracks(String albumID) {
        String url = "https://theaudiodb.com/api/v1/json/1/track.php?m=" + albumID;

        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("error", e.getMessage());
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.body() != null) {
                    String songs = response.body().string();
                    Log.d("response", songs);

                    runOnUiThread(() -> updateUI(songs));

                }

            }
        });
    }

    private void updateUI(String tracks) {

        Gson gson = new Gson();
        tracksContainer = gson.fromJson(tracks, TracksContainer.class);

        if (tracksContainer != null) {
            if (tracksContainer.getTracksSize() > 0) {
                tracksAdapter = new TracksAdapter(SongsActivity.this, tracksContainer, progressBar, alertDialog);
                ItemTouchHelper.Callback callback = new ItemMoveCallback(tracksAdapter);
                ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
                touchHelper.attachToRecyclerView(recyclerView);
                recyclerView.setAdapter(tracksAdapter);
                progressBar.setVisibility(View.GONE);
            } else {
                progressBar.setVisibility(View.GONE);
                Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.rate_no_item_found), Snackbar.LENGTH_LONG).show();
            }
        } else {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.rate_no_item_found), Snackbar.LENGTH_LONG).show();
        }

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void alertNoConnection() {
        alertDialog = new AlertDialog.Builder(SongsActivity.this)
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
