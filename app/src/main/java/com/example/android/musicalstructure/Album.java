package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ivanna on 13.03.18. Have you declared this activity in your AndroidManifest.xml?
 */

public class Album extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.this_album);

        // Create a list of songs
        ArrayList<Song> albumSongs = new ArrayList<>();

        albumSongs.add(new Song("Monatik", "Звучит", 1, "Мудрые деревья", 4.44));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Кружит", 3.17));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Тише", 4.03));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Музыкально-танцевальная терапия", 0.33));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Пока ты на танцполе", 0.47));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Мокрая", 3.56));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Путь", 4.24));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "УВЛИУВТ (Упали в любовь и ударились в танцы)", 4.02));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Каждый из нас", 0.40));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Ещё один", 3.28));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Засияем", 0.31));
        albumSongs.add(new Song("Monatik", "Звучит", 1, "Сейчас", 3.42));


        AlbumAdapter adapter = new AlbumAdapter(this, albumSongs);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        ImageButton equalizer = findViewById(R.id.imageButton_equalizer);

        equalizer.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent nowPlayingIntent = new Intent(Album.this, MainActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        ImageButton shineStar = findViewById(R.id.imageButton_shine_star);

        shineStar.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent playlistIntent = new Intent(Album.this, Playlist.class);
                startActivity(playlistIntent);
            }
        });

        ImageButton cd = findViewById(R.id.imageButton_cd);

        cd.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent albumIntent = new Intent(Album.this, Album.class);
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

