package com.gmail.abhishekdas1503.email.popularmovies;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
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

        TextView title = (TextView) rootView.findViewById(R.id.title);
        title.setText(movie.getTitle());

        MovieView movieView = (MovieView) rootView.findViewById(R.id.poster);
        movieView.showMovie(movie);

        TextView release = (TextView) rootView.findViewById(R.id.release);
        release.setText(movie.getReleaseDate().substring(0, 4));

        TextView vote = (TextView) rootView.findViewById(R.id.vote);
        vote.setText(movie.getVoteAverage() + "/10");

        TextView synopsis = (TextView) rootView.findViewById(R.id.synopsis);
        synopsis.setText(movie.getOverview());

        return rootView;
    }
}
