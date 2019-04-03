package com.example.audiodb.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumContainer {

    @SerializedName("album")
    @Expose
    private List<Album> album = null;

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public int getAlbumSize() {
        if (album != null) {
            if (album.size() > 0) {
                return album.size();
            }
        }
        return 0;
    }

}
