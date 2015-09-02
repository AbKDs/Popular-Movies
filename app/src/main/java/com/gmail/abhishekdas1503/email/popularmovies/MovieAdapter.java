package com.gmail.abhishekdas1503.email.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Custom implementation of Adapter {@link BaseAdapter}which will store
 * LinearLayout views that contain one ImageView to display
 * the image of Movie as downloaded from MovieDB API and
 * name of the movie in the TextView below it
 */
public class MovieAdapter extends BaseAdapter {
    // Stores a list of movie objects
    private List<Movie> mMovieList;

    // Context of the caller method
    private Context mContext;

    // Layout Inflater from the context
    private LayoutInflater mInflater;

    public MovieAdapter(Context context, List<Movie> movieList) {
        mMovieList = movieList;
        mContext = context;

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieList.get(position);
    }

    /* Used when we need a Unique ID associated with our item.
     * Generally when there are rows returned from a sql database.
     * Not using this function. Have to override since it is
     * abstract.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieView movieView;
        if (convertView == null) {
            movieView = (MovieView) mInflater.inflate(R.layout.grid_item_movie, null);
        } else {
            movieView = (MovieView) convertView;
        }

        // returns a movie object from the mMovieList
        Movie movie= (Movie) getItem(position);
        movieView.showMovie(movie);
        return movieView;
    }
}
