package com.example.android.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ivanna on 12.03.18.
 */

public class AlbumAdapter extends ArrayAdapter<Song> {

    public AlbumAdapter(Activity context, ArrayList<Song> albumSongs) {

        super(context, 0, albumSongs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_song_list, parent, false);
        }


        Song currentSong = getItem(position);

        TextView songTitleTextView = listItemView.findViewById(R.id.song_title);
        songTitleTextView.setText((position + 1) + ". " + currentSong.getSong() + " (" + currentSong.getSongLength() + ")");

        return listItemView;
    }


}
