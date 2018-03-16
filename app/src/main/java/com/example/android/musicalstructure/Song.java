package com.example.android.musicalstructure;


import java.text.DecimalFormat;

/**
 * Non-public, non-static field names start with m.
 */

public class Song {

    private String mArtist;

    private String mAlbumTitle;
    private int mAlbumImage;

    private String mSong;
    private double mSongLength;


    public Song(String vArtist, String vAlbumTitle, int vAlbumImage, String vSong, double vSongLength) {

        mArtist = vArtist;
        mAlbumTitle = vAlbumTitle;
        mAlbumImage = vAlbumImage;
        mSong = vSong;
        mSongLength = vSongLength;

    }


    public String getArtist() {
        return mArtist;
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public int getAlbumImage() {
        return mAlbumImage;
    }

    public String getSong() {
        return mSong;
    }

    /**
     * Use the DecimalFormat class to format decimal numbers into locale-specific strings. Use this to show song length as "3.50" instead of "3.5".
     */

    public String getSongLength() {

        DecimalFormat df = new DecimalFormat("0.00");
        String decimalFormatSongLength = df.format(mSongLength);
        return decimalFormatSongLength;
    }

}