package com.gmail.abhishekdas1503.email.popularmovies;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.gmail.abhishekdas1503.email.popularmovies.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates fetching the movie details and displaying it as {@link GridView} layout
 */
public class MovieFragment extends Fragment {
    private MovieAdapter mMovieAdapter;
    private List<Movie> mMovieList = new ArrayList<>();

    public MovieFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mMovieAdapter = new MovieAdapter(
                getActivity(),    // Context of the app
                mMovieList
        );

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview_movies);
        gridView.setAdapter(mMovieAdapter);

        updateMovies();

        return rootView;
    }

    /**
     * @param:void
     * Helper function to download the content from movieDB and set it to the
     * movieAdapter
     */

    void updateMovies() {}
}