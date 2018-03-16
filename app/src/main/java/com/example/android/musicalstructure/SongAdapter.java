package com.example.android.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ivanna on 12.03.18.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> playlistSongs) {

        super(context, 0, playlistSongs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_card, parent, false);
        }


        Song currentSong = getItem(position);

        TextView songTitleTextView = listItemView.findViewById(R.id.song_title);
        songTitleTextView.setText(currentSong.getSong() + " (" + currentSong.getSongLength() + ")");

        TextView artistNameTextView = listItemView.findViewById(R.id.artist_name);
        artistNameTextView.setText(currentSong.getArtist());


        ImageView albumImageView = listItemView.findViewById(R.id.thumbnail);
        albumImageView.setImageResource(currentSong.getAlbumImage());

        return listItemView;
    }


}
