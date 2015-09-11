package com.gmail.abhishekdas1503.email.popularmovies;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.gmail.abhishekdas1503.email.popularmovies.model.Movie;
import com.gmail.abhishekdas1503.email.popularmovies.model.MovieResponse;
import com.gmail.abhishekdas1503.email.popularmovies.network.TMovieDBService;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

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

        // updateMovies();

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        updateMovies();
    }

    /**
     * @param:void
     * Helper function to download the content from movieDB and set it to the
     * movieAdapter
     */

    void updateMovies() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.themoviedb.org/3/discover")
                .build();
        // String sortKey = "popularity.desc";
        TMovieDBService service = restAdapter.create(TMovieDBService.class);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String sortKey = prefs.getString("sortkey", "");
        String key = getQuery(sortKey);

        service.getMovieResponse(key, ApiKey.API_KEY,
                new Callback<MovieResponse>() {
                    @Override
                    public void success(MovieResponse movieResponse, Response response) {
                        mMovieAdapter.addAll(movieResponse.getMovies());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        // Toast for the moment
                        // Appropriate error handling code should be present here
                        Toast.makeText(getActivity(), "Failed !", Toast.LENGTH_LONG).show();
                    }
                });
    }

    /**
     * @param sortKey
     * Takes in the preference and returns the key to be passed
     * to the api to get the movies
     * */
    String getQuery(String sortKey) {
        return sortKey.equals("popular")?"popularity.desc":"vote_average.desc";
    }
}
