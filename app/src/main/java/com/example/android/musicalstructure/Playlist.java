package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ivanna on 12.03.18. Have you declared this activity in your AndroidManifest.xml?
 */

public class Playlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        // Create album image numbers

        int[] albumImages = new int[]{
                R.drawable.ma1000x1000,
                R.drawable.mb1000x1000,
                R.drawable.mf1000x1000,
                R.drawable.md1000x1000,
                R.drawable.mc1000x1000};

        // Create a list of songs
        ArrayList<Song> playlistSongs = new ArrayList<>();
        playlistSongs.add(new Song("Linkin Park", "Hybrid Theory", albumImages[0], "One Step Closer", 2.37));
        playlistSongs.add(new Song("Monatik", "Звучит", albumImages[1], "Сейчас", 3.42));
        playlistSongs.add(new Song("David Guetta", "The World Is Mine", albumImages[2], "The World Is Mine", 3.40));
        playlistSongs.add(new Song("Artik & Asti", "Здесь и сейчас", albumImages[3], "Кто я тебе?!", 3.08));
        playlistSongs.add(new Song("Justin Bieber", "Purpose Deluxe", albumImages[4], "Company", 3.28));


        SongAdapter adapter = new SongAdapter(this, playlistSongs);

        GridView listView = findViewById(R.id.gridview);
        listView.setAdapter(adapter);


        ImageButton equalizer = findViewById(R.id.imageButton_equalizer);

        equalizer.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent nowPlayingIntent = new Intent(Playlist.this, MainActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        ImageButton shineStar = findViewById(R.id.imageButton_shine_star);

        shineStar.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent playlistIntent = new Intent(Playlist.this, Playlist.class);
                startActivity(playlistIntent);
            }
        });

        ImageButton cd = findViewById(R.id.imageButton_cd);

        cd.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent albumIntent = new Intent(Playlist.this, Album.class);
                startActivity(albumIntent);
            }
        });

        ImageButton shareSymbol = findViewById(R.id.imageButton_share_symbol);


        shareSymbol.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                TextView artistNameTextView = findViewById(R.id.textView_artist);
                final String artistNameString = artistNameTextView.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey! I am listening to " + artistNameString + " in Music Structure app! It's amazing!");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }
}
