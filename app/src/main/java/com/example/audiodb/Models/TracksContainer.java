package com.example.audiodb.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TracksContainer {
    @SerializedName("track")
    @Expose
    private List<Track> track = null;

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }

    public int getTracksSize() {
        if (track != null) {
            if (track.size() > 0) {
                return track.size();
            }
        }
        return 0;
    }
}
