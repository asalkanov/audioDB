package com.example.audiodb.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("idTrack")
    @Expose
    private String idTrack;
    @SerializedName("idAlbum")
    @Expose
    private String idAlbum;
    @SerializedName("idArtist")
    @Expose
    private String idArtist;
    @SerializedName("idLyric")
    @Expose
    private String idLyric;
    @SerializedName("idIMVDB")
    @Expose
    private Object idIMVDB;
    @SerializedName("strTrack")
    @Expose
    private String strTrack;
    @SerializedName("strAlbum")
    @Expose
    private String strAlbum;
    @SerializedName("strArtist")
    @Expose
    private String strArtist;
    @SerializedName("strArtistAlternate")
    @Expose
    private Object strArtistAlternate;
    @SerializedName("intCD")
    @Expose
    private Object intCD;
    @SerializedName("intDuration")
    @Expose
    private String intDuration;
    @SerializedName("strGenre")
    @Expose
    private String strGenre;
    @SerializedName("strMood")
    @Expose
    private Object strMood;
    @SerializedName("strStyle")
    @Expose
    private Object strStyle;
    @SerializedName("strTheme")
    @Expose
    private Object strTheme;
    @SerializedName("strDescriptionEN")
    @Expose
    private Object strDescriptionEN;
    @SerializedName("strTrackThumb")
    @Expose
    private Object strTrackThumb;
    @SerializedName("strTrackLyrics")
    @Expose
    private Object strTrackLyrics;
    @SerializedName("strMusicVid")
    @Expose
    private Object strMusicVid;
    @SerializedName("strMusicVidDirector")
    @Expose
    private Object strMusicVidDirector;
    @SerializedName("strMusicVidCompany")
    @Expose
    private Object strMusicVidCompany;
    @SerializedName("strMusicVidScreen1")
    @Expose
    private Object strMusicVidScreen1;
    @SerializedName("strMusicVidScreen2")
    @Expose
    private Object strMusicVidScreen2;
    @SerializedName("strMusicVidScreen3")
    @Expose
    private Object strMusicVidScreen3;
    @SerializedName("intMusicVidViews")
    @Expose
    private Object intMusicVidViews;
    @SerializedName("intMusicVidLikes")
    @Expose
    private Object intMusicVidLikes;
    @SerializedName("intMusicVidDislikes")
    @Expose
    private Object intMusicVidDislikes;
    @SerializedName("intMusicVidFavorites")
    @Expose
    private Object intMusicVidFavorites;
    @SerializedName("intMusicVidComments")
    @Expose
    private Object intMusicVidComments;
    @SerializedName("intTrackNumber")
    @Expose
    private String intTrackNumber;
    @SerializedName("intLoved")
    @Expose
    private String intLoved;
    @SerializedName("intScore")
    @Expose
    private Object intScore;
    @SerializedName("intScoreVotes")
    @Expose
    private Object intScoreVotes;
    @SerializedName("intTotalListeners")
    @Expose
    private Object intTotalListeners;
    @SerializedName("intTotalPlays")
    @Expose
    private Object intTotalPlays;
    @SerializedName("strMusicBrainzID")
    @Expose
    private String strMusicBrainzID;
    @SerializedName("strMusicBrainzAlbumID")
    @Expose
    private String strMusicBrainzAlbumID;
    @SerializedName("strMusicBrainzArtistID")
    @Expose
    private String strMusicBrainzArtistID;
    @SerializedName("strLocked")
    @Expose
    private String strLocked;

    public String getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(String idTrack) {
        this.idTrack = idTrack;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(String idArtist) {
        this.idArtist = idArtist;
    }

    public String getIdLyric() {
        return idLyric;
    }

    public void setIdLyric(String idLyric) {
        this.idLyric = idLyric;
    }

    public Object getIdIMVDB() {
        return idIMVDB;
    }

    public void setIdIMVDB(Object idIMVDB) {
        this.idIMVDB = idIMVDB;
    }

    public String getStrTrack() {
        return strTrack;
    }

    public void setStrTrack(String strTrack) {
        this.strTrack = strTrack;
    }

    public String getStrAlbum() {
        return strAlbum;
    }

    public void setStrAlbum(String strAlbum) {
        this.strAlbum = strAlbum;
    }

    public String getStrArtist() {
        return strArtist;
    }

    public void setStrArtist(String strArtist) {
        this.strArtist = strArtist;
    }

    public Object getStrArtistAlternate() {
        return strArtistAlternate;
    }

    public void setStrArtistAlternate(Object strArtistAlternate) {
        this.strArtistAlternate = strArtistAlternate;
    }

    public Object getIntCD() {
        return intCD;
    }

    public void setIntCD(Object intCD) {
        this.intCD = intCD;
    }

    public String getIntDuration() {
        return intDuration;
    }

    public void setIntDuration(String intDuration) {
        this.intDuration = intDuration;
    }

    public String getStrGenre() {
        return strGenre;
    }

    public void setStrGenre(String strGenre) {
        this.strGenre = strGenre;
    }

    public Object getStrMood() {
        return strMood;
    }

    public void setStrMood(Object strMood) {
        this.strMood = strMood;
    }

    public Object getStrStyle() {
        return strStyle;
    }

    public void setStrStyle(Object strStyle) {
        this.strStyle = strStyle;
    }

    public Object getStrTheme() {
        return strTheme;
    }

    public void setStrTheme(Object strTheme) {
        this.strTheme = strTheme;
    }

    public Object getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(Object strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public Object getStrTrackThumb() {
        return strTrackThumb;
    }

    public void setStrTrackThumb(Object strTrackThumb) {
        this.strTrackThumb = strTrackThumb;
    }

    public Object getStrTrackLyrics() {
        return strTrackLyrics;
    }

    public void setStrTrackLyrics(Object strTrackLyrics) {
        this.strTrackLyrics = strTrackLyrics;
    }

    public Object getStrMusicVid() {
        return strMusicVid;
    }

    public void setStrMusicVid(Object strMusicVid) {
        this.strMusicVid = strMusicVid;
    }

    public Object getStrMusicVidDirector() {
        return strMusicVidDirector;
    }

    public void setStrMusicVidDirector(Object strMusicVidDirector) {
        this.strMusicVidDirector = strMusicVidDirector;
    }

    public Object getStrMusicVidCompany() {
        return strMusicVidCompany;
    }

    public void setStrMusicVidCompany(Object strMusicVidCompany) {
        this.strMusicVidCompany = strMusicVidCompany;
    }

    public Object getStrMusicVidScreen1() {
        return strMusicVidScreen1;
    }

    public void setStrMusicVidScreen1(Object strMusicVidScreen1) {
        this.strMusicVidScreen1 = strMusicVidScreen1;
    }

    public Object getStrMusicVidScreen2() {
        return strMusicVidScreen2;
    }

    public void setStrMusicVidScreen2(Object strMusicVidScreen2) {
        this.strMusicVidScreen2 = strMusicVidScreen2;
    }

    public Object getStrMusicVidScreen3() {
        return strMusicVidScreen3;
    }

    public void setStrMusicVidScreen3(Object strMusicVidScreen3) {
        this.strMusicVidScreen3 = strMusicVidScreen3;
    }

    public Object getIntMusicVidViews() {
        return intMusicVidViews;
    }

    public void setIntMusicVidViews(Object intMusicVidViews) {
        this.intMusicVidViews = intMusicVidViews;
    }

    public Object getIntMusicVidLikes() {
        return intMusicVidLikes;
    }

    public void setIntMusicVidLikes(Object intMusicVidLikes) {
        this.intMusicVidLikes = intMusicVidLikes;
    }

    public Object getIntMusicVidDislikes() {
        return intMusicVidDislikes;
    }

    public void setIntMusicVidDislikes(Object intMusicVidDislikes) {
        this.intMusicVidDislikes = intMusicVidDislikes;
    }

    public Object getIntMusicVidFavorites() {
        return intMusicVidFavorites;
    }

    public void setIntMusicVidFavorites(Object intMusicVidFavorites) {
        this.intMusicVidFavorites = intMusicVidFavorites;
    }

    public Object getIntMusicVidComments() {
        return intMusicVidComments;
    }

    public void setIntMusicVidComments(Object intMusicVidComments) {
        this.intMusicVidComments = intMusicVidComments;
    }

    public String getIntTrackNumber() {
        return intTrackNumber;
    }

    public void setIntTrackNumber(String intTrackNumber) {
        this.intTrackNumber = intTrackNumber;
    }

    public String getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(String intLoved) {
        this.intLoved = intLoved;
    }

    public Object getIntScore() {
        return intScore;
    }

    public void setIntScore(Object intScore) {
        this.intScore = intScore;
    }

    public Object getIntScoreVotes() {
        return intScoreVotes;
    }

    public void setIntScoreVotes(Object intScoreVotes) {
        this.intScoreVotes = intScoreVotes;
    }

    public Object getIntTotalListeners() {
        return intTotalListeners;
    }

    public void setIntTotalListeners(Object intTotalListeners) {
        this.intTotalListeners = intTotalListeners;
    }

    public Object getIntTotalPlays() {
        return intTotalPlays;
    }

    public void setIntTotalPlays(Object intTotalPlays) {
        this.intTotalPlays = intTotalPlays;
    }

    public String getStrMusicBrainzID() {
        return strMusicBrainzID;
    }

    public void setStrMusicBrainzID(String strMusicBrainzID) {
        this.strMusicBrainzID = strMusicBrainzID;
    }

    public String getStrMusicBrainzAlbumID() {
        return strMusicBrainzAlbumID;
    }

    public void setStrMusicBrainzAlbumID(String strMusicBrainzAlbumID) {
        this.strMusicBrainzAlbumID = strMusicBrainzAlbumID;
    }

    public String getStrMusicBrainzArtistID() {
        return strMusicBrainzArtistID;
    }

    public void setStrMusicBrainzArtistID(String strMusicBrainzArtistID) {
        this.strMusicBrainzArtistID = strMusicBrainzArtistID;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

}