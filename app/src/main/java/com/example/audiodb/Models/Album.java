package com.example.audiodb.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("idAlbum")
    @Expose
    private String idAlbum;
    @SerializedName("idArtist")
    @Expose
    private String idArtist;
    @SerializedName("idLabel")
    @Expose
    private String idLabel;
    @SerializedName("strAlbum")
    @Expose
    private String strAlbum;
    @SerializedName("strAlbumStripped")
    @Expose
    private String strAlbumStripped;
    @SerializedName("strArtist")
    @Expose
    private String strArtist;
    @SerializedName("strArtistStripped")
    @Expose
    private String strArtistStripped;
    @SerializedName("intYearReleased")
    @Expose
    private String intYearReleased;
    @SerializedName("strStyle")
    @Expose
    private String strStyle;
    @SerializedName("strGenre")
    @Expose
    private String strGenre;
    @SerializedName("strLabel")
    @Expose
    private String strLabel;
    @SerializedName("strReleaseFormat")
    @Expose
    private String strReleaseFormat;
    @SerializedName("intSales")
    @Expose
    private String intSales;
    @SerializedName("strAlbumThumb")
    @Expose
    private String strAlbumThumb;
    @SerializedName("strAlbumThumbHQ")
    @Expose
    private Object strAlbumThumbHQ;
    @SerializedName("strAlbumThumbBack")
    @Expose
    private Object strAlbumThumbBack;
    @SerializedName("strAlbumCDart")
    @Expose
    private String strAlbumCDart;
    @SerializedName("strAlbumSpine")
    @Expose
    private Object strAlbumSpine;
    @SerializedName("strAlbum3DCase")
    @Expose
    private Object strAlbum3DCase;
    @SerializedName("strAlbum3DFlat")
    @Expose
    private Object strAlbum3DFlat;
    @SerializedName("strAlbum3DFace")
    @Expose
    private Object strAlbum3DFace;
    @SerializedName("strDescriptionEN")
    @Expose
    private String strDescriptionEN;
    @SerializedName("strDescriptionDE")
    @Expose
    private Object strDescriptionDE;
    @SerializedName("strDescriptionFR")
    @Expose
    private Object strDescriptionFR;
    @SerializedName("strDescriptionCN")
    @Expose
    private Object strDescriptionCN;
    @SerializedName("strDescriptionIT")
    @Expose
    private Object strDescriptionIT;
    @SerializedName("strDescriptionJP")
    @Expose
    private Object strDescriptionJP;
    @SerializedName("strDescriptionRU")
    @Expose
    private Object strDescriptionRU;
    @SerializedName("strDescriptionES")
    @Expose
    private Object strDescriptionES;
    @SerializedName("strDescriptionPT")
    @Expose
    private Object strDescriptionPT;
    @SerializedName("strDescriptionSE")
    @Expose
    private Object strDescriptionSE;
    @SerializedName("strDescriptionNL")
    @Expose
    private Object strDescriptionNL;
    @SerializedName("strDescriptionHU")
    @Expose
    private Object strDescriptionHU;
    @SerializedName("strDescriptionNO")
    @Expose
    private Object strDescriptionNO;
    @SerializedName("strDescriptionIL")
    @Expose
    private Object strDescriptionIL;
    @SerializedName("strDescriptionPL")
    @Expose
    private Object strDescriptionPL;
    @SerializedName("intLoved")
    @Expose
    private Object intLoved;
    @SerializedName("intScore")
    @Expose
    private String intScore;
    @SerializedName("intScoreVotes")
    @Expose
    private String intScoreVotes;
    @SerializedName("strReview")
    @Expose
    private String strReview;
    @SerializedName("strMood")
    @Expose
    private String strMood;
    @SerializedName("strTheme")
    @Expose
    private String strTheme;
    @SerializedName("strSpeed")
    @Expose
    private String strSpeed;
    @SerializedName("strLocation")
    @Expose
    private Object strLocation;
    @SerializedName("strMusicBrainzID")
    @Expose
    private String strMusicBrainzID;
    @SerializedName("strMusicBrainzArtistID")
    @Expose
    private String strMusicBrainzArtistID;
    @SerializedName("strAllMusicID")
    @Expose
    private Object strAllMusicID;
    @SerializedName("strBBCReviewID")
    @Expose
    private Object strBBCReviewID;
    @SerializedName("strRateYourMusicID")
    @Expose
    private Object strRateYourMusicID;
    @SerializedName("strDiscogsID")
    @Expose
    private Object strDiscogsID;
    @SerializedName("strWikidataID")
    @Expose
    private Object strWikidataID;
    @SerializedName("strWikipediaID")
    @Expose
    private Object strWikipediaID;
    @SerializedName("strGeniusID")
    @Expose
    private Object strGeniusID;
    @SerializedName("strLyricWikiID")
    @Expose
    private Object strLyricWikiID;
    @SerializedName("strMusicMozID")
    @Expose
    private Object strMusicMozID;
    @SerializedName("strItunesID")
    @Expose
    private Object strItunesID;
    @SerializedName("strAmazonID")
    @Expose
    private Object strAmazonID;
    @SerializedName("strLocked")
    @Expose
    private String strLocked;

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

    public String getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(String idLabel) {
        this.idLabel = idLabel;
    }

    public String getStrAlbum() {
        return strAlbum;
    }

    public void setStrAlbum(String strAlbum) {
        this.strAlbum = strAlbum;
    }

    public String getStrAlbumStripped() {
        return strAlbumStripped;
    }

    public void setStrAlbumStripped(String strAlbumStripped) {
        this.strAlbumStripped = strAlbumStripped;
    }

    public String getStrArtist() {
        return strArtist;
    }

    public void setStrArtist(String strArtist) {
        this.strArtist = strArtist;
    }

    public String getStrArtistStripped() {
        return strArtistStripped;
    }

    public void setStrArtistStripped(String strArtistStripped) {
        this.strArtistStripped = strArtistStripped;
    }

    public String getIntYearReleased() {
        return intYearReleased;
    }

    public void setIntYearReleased(String intYearReleased) {
        this.intYearReleased = intYearReleased;
    }

    public String getStrStyle() {
        return strStyle;
    }

    public void setStrStyle(String strStyle) {
        this.strStyle = strStyle;
    }

    public String getStrGenre() {
        return strGenre;
    }

    public void setStrGenre(String strGenre) {
        this.strGenre = strGenre;
    }

    public String getStrLabel() {
        return strLabel;
    }

    public void setStrLabel(String strLabel) {
        this.strLabel = strLabel;
    }

    public String getStrReleaseFormat() {
        return strReleaseFormat;
    }

    public void setStrReleaseFormat(String strReleaseFormat) {
        this.strReleaseFormat = strReleaseFormat;
    }

    public String getIntSales() {
        return intSales;
    }

    public void setIntSales(String intSales) {
        this.intSales = intSales;
    }

    public String getStrAlbumThumb() {
        return strAlbumThumb;
    }

    public void setStrAlbumThumb(String strAlbumThumb) {
        this.strAlbumThumb = strAlbumThumb;
    }

    public Object getStrAlbumThumbHQ() {
        return strAlbumThumbHQ;
    }

    public void setStrAlbumThumbHQ(Object strAlbumThumbHQ) {
        this.strAlbumThumbHQ = strAlbumThumbHQ;
    }

    public Object getStrAlbumThumbBack() {
        return strAlbumThumbBack;
    }

    public void setStrAlbumThumbBack(Object strAlbumThumbBack) {
        this.strAlbumThumbBack = strAlbumThumbBack;
    }

    public String getStrAlbumCDart() {
        return strAlbumCDart;
    }

    public void setStrAlbumCDart(String strAlbumCDart) {
        this.strAlbumCDart = strAlbumCDart;
    }

    public Object getStrAlbumSpine() {
        return strAlbumSpine;
    }

    public void setStrAlbumSpine(Object strAlbumSpine) {
        this.strAlbumSpine = strAlbumSpine;
    }

    public Object getStrAlbum3DCase() {
        return strAlbum3DCase;
    }

    public void setStrAlbum3DCase(Object strAlbum3DCase) {
        this.strAlbum3DCase = strAlbum3DCase;
    }

    public Object getStrAlbum3DFlat() {
        return strAlbum3DFlat;
    }

    public void setStrAlbum3DFlat(Object strAlbum3DFlat) {
        this.strAlbum3DFlat = strAlbum3DFlat;
    }

    public Object getStrAlbum3DFace() {
        return strAlbum3DFace;
    }

    public void setStrAlbum3DFace(Object strAlbum3DFace) {
        this.strAlbum3DFace = strAlbum3DFace;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public Object getStrDescriptionDE() {
        return strDescriptionDE;
    }

    public void setStrDescriptionDE(Object strDescriptionDE) {
        this.strDescriptionDE = strDescriptionDE;
    }

    public Object getStrDescriptionFR() {
        return strDescriptionFR;
    }

    public void setStrDescriptionFR(Object strDescriptionFR) {
        this.strDescriptionFR = strDescriptionFR;
    }

    public Object getStrDescriptionCN() {
        return strDescriptionCN;
    }

    public void setStrDescriptionCN(Object strDescriptionCN) {
        this.strDescriptionCN = strDescriptionCN;
    }

    public Object getStrDescriptionIT() {
        return strDescriptionIT;
    }

    public void setStrDescriptionIT(Object strDescriptionIT) {
        this.strDescriptionIT = strDescriptionIT;
    }

    public Object getStrDescriptionJP() {
        return strDescriptionJP;
    }

    public void setStrDescriptionJP(Object strDescriptionJP) {
        this.strDescriptionJP = strDescriptionJP;
    }

    public Object getStrDescriptionRU() {
        return strDescriptionRU;
    }

    public void setStrDescriptionRU(Object strDescriptionRU) {
        this.strDescriptionRU = strDescriptionRU;
    }

    public Object getStrDescriptionES() {
        return strDescriptionES;
    }

    public void setStrDescriptionES(Object strDescriptionES) {
        this.strDescriptionES = strDescriptionES;
    }

    public Object getStrDescriptionPT() {
        return strDescriptionPT;
    }

    public void setStrDescriptionPT(Object strDescriptionPT) {
        this.strDescriptionPT = strDescriptionPT;
    }

    public Object getStrDescriptionSE() {
        return strDescriptionSE;
    }

    public void setStrDescriptionSE(Object strDescriptionSE) {
        this.strDescriptionSE = strDescriptionSE;
    }

    public Object getStrDescriptionNL() {
        return strDescriptionNL;
    }

    public void setStrDescriptionNL(Object strDescriptionNL) {
        this.strDescriptionNL = strDescriptionNL;
    }

    public Object getStrDescriptionHU() {
        return strDescriptionHU;
    }

    public void setStrDescriptionHU(Object strDescriptionHU) {
        this.strDescriptionHU = strDescriptionHU;
    }

    public Object getStrDescriptionNO() {
        return strDescriptionNO;
    }

    public void setStrDescriptionNO(Object strDescriptionNO) {
        this.strDescriptionNO = strDescriptionNO;
    }

    public Object getStrDescriptionIL() {
        return strDescriptionIL;
    }

    public void setStrDescriptionIL(Object strDescriptionIL) {
        this.strDescriptionIL = strDescriptionIL;
    }

    public Object getStrDescriptionPL() {
        return strDescriptionPL;
    }

    public void setStrDescriptionPL(Object strDescriptionPL) {
        this.strDescriptionPL = strDescriptionPL;
    }

    public Object getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(Object intLoved) {
        this.intLoved = intLoved;
    }

    public String getIntScore() {
        return intScore;
    }

    public void setIntScore(String intScore) {
        this.intScore = intScore;
    }

    public String getIntScoreVotes() {
        return intScoreVotes;
    }

    public void setIntScoreVotes(String intScoreVotes) {
        this.intScoreVotes = intScoreVotes;
    }

    public String getStrReview() {
        return strReview;
    }

    public void setStrReview(String strReview) {
        this.strReview = strReview;
    }

    public String getStrMood() {
        return strMood;
    }

    public void setStrMood(String strMood) {
        this.strMood = strMood;
    }

    public String getStrTheme() {
        return strTheme;
    }

    public void setStrTheme(String strTheme) {
        this.strTheme = strTheme;
    }

    public String getStrSpeed() {
        return strSpeed;
    }

    public void setStrSpeed(String strSpeed) {
        this.strSpeed = strSpeed;
    }

    public Object getStrLocation() {
        return strLocation;
    }

    public void setStrLocation(Object strLocation) {
        this.strLocation = strLocation;
    }

    public String getStrMusicBrainzID() {
        return strMusicBrainzID;
    }

    public void setStrMusicBrainzID(String strMusicBrainzID) {
        this.strMusicBrainzID = strMusicBrainzID;
    }

    public String getStrMusicBrainzArtistID() {
        return strMusicBrainzArtistID;
    }

    public void setStrMusicBrainzArtistID(String strMusicBrainzArtistID) {
        this.strMusicBrainzArtistID = strMusicBrainzArtistID;
    }

    public Object getStrAllMusicID() {
        return strAllMusicID;
    }

    public void setStrAllMusicID(Object strAllMusicID) {
        this.strAllMusicID = strAllMusicID;
    }

    public Object getStrBBCReviewID() {
        return strBBCReviewID;
    }

    public void setStrBBCReviewID(Object strBBCReviewID) {
        this.strBBCReviewID = strBBCReviewID;
    }

    public Object getStrRateYourMusicID() {
        return strRateYourMusicID;
    }

    public void setStrRateYourMusicID(Object strRateYourMusicID) {
        this.strRateYourMusicID = strRateYourMusicID;
    }

    public Object getStrDiscogsID() {
        return strDiscogsID;
    }

    public void setStrDiscogsID(Object strDiscogsID) {
        this.strDiscogsID = strDiscogsID;
    }

    public Object getStrWikidataID() {
        return strWikidataID;
    }

    public void setStrWikidataID(Object strWikidataID) {
        this.strWikidataID = strWikidataID;
    }

    public Object getStrWikipediaID() {
        return strWikipediaID;
    }

    public void setStrWikipediaID(Object strWikipediaID) {
        this.strWikipediaID = strWikipediaID;
    }

    public Object getStrGeniusID() {
        return strGeniusID;
    }

    public void setStrGeniusID(Object strGeniusID) {
        this.strGeniusID = strGeniusID;
    }

    public Object getStrLyricWikiID() {
        return strLyricWikiID;
    }

    public void setStrLyricWikiID(Object strLyricWikiID) {
        this.strLyricWikiID = strLyricWikiID;
    }

    public Object getStrMusicMozID() {
        return strMusicMozID;
    }

    public void setStrMusicMozID(Object strMusicMozID) {
        this.strMusicMozID = strMusicMozID;
    }

    public Object getStrItunesID() {
        return strItunesID;
    }

    public void setStrItunesID(Object strItunesID) {
        this.strItunesID = strItunesID;
    }

    public Object getStrAmazonID() {
        return strAmazonID;
    }

    public void setStrAmazonID(Object strAmazonID) {
        this.strAmazonID = strAmazonID;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

}
