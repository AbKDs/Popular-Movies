package com.gmail.abhishekdas1503.email.popularmovies;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.abhishekdas1503.email.popularmovies.model.Movie;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent movieIntent = getActivity().getIntent();
        Movie movie = movieIntent.getExtras().getParcelable("movie");

        TextView tv = (TextView) rootView.findViewById(R.id.textView);
        Log.d("Reached here", "Oh yeah");
        tv.setText(movie.getTitle() /*+ " " + movie.getOverview() + " "
                + movie.getVoteAverage()*/);
        Log.d("Couldn't Reached here", "Oh no");
        return rootView;
    }
}
