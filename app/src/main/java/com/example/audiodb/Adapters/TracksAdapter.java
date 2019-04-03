package com.example.audiodb.Adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.audiodb.MainActivity;
import com.example.audiodb.R;
import com.example.audiodb.SongsActivity;
import com.example.audiodb.Models.Track;
import com.example.audiodb.Models.TracksContainer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.TracksViewHolder> implements ItemTouchHelperAdapter {
    private Context context;
    private LayoutInflater inflater;
    private TracksContainer tracksContainer;
    private ProgressBar progressBar;
    private AlertDialog alertDialog;
    private boolean highlight = false;
    private Integer highlightPosition = -1;

    public TracksAdapter(Context context, TracksContainer tracksContainer, ProgressBar progressBar, AlertDialog alertDialog) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.tracksContainer = tracksContainer;
        this.progressBar = progressBar;
        this.alertDialog = alertDialog;
    }

    @NonNull
    @Override
    public TracksAdapter.TracksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.track_item, parent, false);
        return new TracksAdapter.TracksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TracksViewHolder holder, int position) {

        List<Track> trackList = tracksContainer.getTrack();
        Track track = trackList.get(position);
        holder.trackName.setText(String.format(context.getResources().getString(R.string.track_number_title), track.getIntTrackNumber(), track.getStrTrack()));

        String trackDuration = track.getIntDuration();

        int seconds = (int) (Long.parseLong(trackDuration) / 1000) % 60 ;
        int minutes = (int) ((Long.parseLong(trackDuration) / (1000*60)) % 60);

        holder.trackDuration.setText(String.format(Locale.getDefault(), "Duration: %d:%02d", minutes, seconds));

        if (track.getIntScore() != null) {
            if (!track.getIntScore().equals("")) {
                holder.trackScore.setText(String.format(Locale.getDefault(), "%.2f", Float.parseFloat(track.getIntScore().toString())));
                holder.trackScore.setVisibility(View.VISIBLE);
            }
        }

        if (highlight) {        // highlight updated row
            if (position == highlightPosition) {
                holder.trackConstraintLayout.setBackgroundColor(context.getResources().getColor(R.color.colorHighlight));
                holder.trackConstraintLayout.postDelayed(() -> {
                    holder.trackConstraintLayout.setBackgroundColor(Color.WHITE);
                }, TimeUnit.SECONDS.toMillis(2));
                highlight = false;
                highlightPosition = -1;
            }

        }

        holder.rateButton.setOnClickListener(v -> {
            // use holder.getAdapterPosition() instead of just 'position'
            if (!isNetworkAvailable()) {
                alertNoConnection();
            } else {
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                showRateDialog(context, track.getIdTrack(), track.getStrArtist(), track.getStrAlbum(), track.getStrTrack(), tracksContainer, holder.getAdapterPosition());
            }
        });

    }


    @Override
    public int getItemCount() {
        return tracksContainer.getTracksSize() > 0 ? tracksContainer.getTracksSize() : 0;
    }

    class TracksViewHolder extends RecyclerView.ViewHolder {

        TextView trackName, trackDuration, trackScore;
        ImageButton rateButton;
        ConstraintLayout trackConstraintLayout;

        TracksViewHolder(View itemView) {
            super(itemView);
            trackName = itemView.findViewById(R.id.trackName);
            trackDuration = itemView.findViewById(R.id.trackDuration);
            trackScore = itemView.findViewById(R.id.trackScore);
            rateButton = itemView.findViewById(R.id.rateButton);
            trackConstraintLayout = itemView.findViewById(R.id.trackConstraintLayout);
        }

    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(tracksContainer.getTrack(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(tracksContainer.getTrack(), i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        tracksContainer.getTrack().remove(position);
        notifyItemRemoved(position);
        Snackbar.make(((Activity)context).findViewById(android.R.id.content), context.getResources().getString(R.string.track_deleted), Snackbar.LENGTH_LONG).show();
    }



    private void showRateDialog(Context context, String idTrack, String artist, String album, String track, TracksContainer tracksContainer, int position){
        final float[] userRating = {0};

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.rate_dialog);

        TextView rate = dialog.findViewById(R.id.rate);

        RatingBar ratingBar = dialog.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
            if(rating < 1.0f) {
                ratingBar.setRating(1.0f);
                rating = 1.0f;
            }
            userRating[0] = rating;
            rate.setText(String.valueOf(rating));
            rate.setVisibility(View.VISIBLE);
        });

        Button rateButton = dialog.findViewById(R.id.rateButton);
        rateButton.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            rateTrack(context.getResources().getString(R.string.username), idTrack, artist, album, track, String.valueOf(userRating[0]), context.getResources().getString(R.string.API_key), tracksContainer, position);
            dialog.dismiss();
        });
        dialog.show();
    }


    private void rateTrack(String username, String idTrack, String artist, String album, String track, String userRating, String APIkey, TracksContainer tracksContainer, int position) {
        if (artist.contains("'")) { artist = artist.replace("'", ""); }
        if (album.contains("'")) { album = album.replace("'", ""); }
        if (track.contains("'")) { track = track.replace("'", ""); }
        String url = "https://theaudiodb.com/api/v1/json/1/submit-track.php?user=" + username + "&artist=" + artist + "&album=" + album + "&track=" + track + "&rating=" + userRating + "&api=" + APIkey;
        Log.d("response", "URL: " + url);
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
                    String rating = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(rating);
                        String result =  jsonObject.getString("result");
                        ((SongsActivity)context).runOnUiThread(() -> updateUI(result, idTrack, userRating, tracksContainer, position));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void updateUI(String result, String idTrack, String userRating, TracksContainer tracksContainer, int position) {
        switch (result) {
            case "SUCCESS New rating":
                getNewTrackScore(idTrack, tracksContainer, position, "new");
                break;
            case "SUCCESS Updated rating":
                getNewTrackScore(idTrack, tracksContainer, position, "updated");
                break;
            case "No item found":
                progressBar.setVisibility(View.GONE);
                Snackbar.make(((Activity)context).findViewById(android.R.id.content), context.getResources().getString(R.string.rate_no_item_found), Snackbar.LENGTH_LONG).show();
                break;
            case "Missing input":
                progressBar.setVisibility(View.GONE);
                Snackbar.make(((Activity)context).findViewById(android.R.id.content), context.getResources().getString(R.string.rate_missing_input), Snackbar.LENGTH_LONG).show();
                break;
        }
        /*
        ((SongsActivity)context).finish();
        ((SongsActivity)context).overridePendingTransition( 0, 0);      // override the default animation
        context.startActivity(((SongsActivity)context).getIntent());
        ((SongsActivity)context).overridePendingTransition( 0, 0);
        */
    }


    private void getNewTrackScore(String idTrack, TracksContainer tracksContainer, int position, String newOrUpdate) {
        String url = "https://theaudiodb.com/api/v1/json/1/track.php?h=" + idTrack;
        Log.d("response", "URL: " + url);
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
                    String newScore = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(newScore);
                        JSONArray jsonArray = jsonObject.getJSONArray("track");
                        JSONObject jsonScore = jsonArray.getJSONObject(0);
                        String updatedScore = jsonScore.getString("intScore");
                        ((SongsActivity)context).runOnUiThread(() -> updateScore(tracksContainer, position, updatedScore, newOrUpdate));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void updateScore(TracksContainer tracksContainer, int position, String updatedScore, String newOrUpdate) {
        tracksContainer.getTrack().get(position).setIntScore(updatedScore);
        notifyItemChanged(position);
        highlight = true;
        highlightPosition = position;

        if (newOrUpdate.equals("new")) {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(((Activity)context).findViewById(android.R.id.content), context.getResources().getString(R.string.rate_submitted), Snackbar.LENGTH_LONG).show();
        } else {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(((Activity)context).findViewById(android.R.id.content), context.getResources().getString(R.string.rate_updated), Snackbar.LENGTH_LONG).show();
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void alertNoConnection() {
         alertDialog = new AlertDialog.Builder(context)
                .setTitle(context.getResources().getString(R.string.no_internet_title))
                .setMessage(context.getResources().getString(R.string.no_internet_message))
                .setPositiveButton(context.getResources().getString(R.string.ok_button), (dialog, which) -> alertDialog.dismiss())
                .show();
    }


}
