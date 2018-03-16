package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton equalizer = findViewById(R.id.imageButton_equalizer);

        equalizer.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent nowPlayingIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        ImageButton shineStar = findViewById(R.id.imageButton_shine_star);

        shineStar.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent playlistIntent = new Intent(MainActivity.this, Playlist.class);
                startActivity(playlistIntent);
            }
        });

        ImageButton cd = findViewById(R.id.imageButton_cd);

        cd.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent albumIntent = new Intent(MainActivity.this, Album.class);
                startActivity(albumIntent);
            }
        });

        ImageButton shareSymbol = findViewById(R.id.imageButton_share_symbol);


        shareSymbol.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                //** Find out what is the current artist name */

                TextView artistNameTextView = findViewById(R.id.textView_artist);
                final String artistNameString = artistNameTextView.getText().toString();

                //** Share info with a friend */

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey! I am listening to " + artistNameString + " in Music Structure app! It's amazing!");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });


    }
}
