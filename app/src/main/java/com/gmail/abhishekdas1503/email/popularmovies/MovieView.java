package com.gmail.abhishekdas1503.email.popularmovies;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gmail.abhishekdas1503.email.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

/**
 * A custom implementation of a view which extends from a LinearLayout
 * and is helps in avoid ViewHolder class by saving the views in the
 * member variables
 */
public class MovieView extends LinearLayout {

    private ImageView mImageView;
    private static final String MOVIE_BASE_URL = "http://image.tmdb.org/t/p";
    private final String SIZE = getAppropriateSize();

    /**
     * @return Appropriate size of image
     *
     * Utility function to get what size of image
     * should be downloaded.
     */
    private String getAppropriateSize() {
       if (Connectivity.isConnectedFast(getContext())) {
           return "w185";
       } else {
           return "w342";
       }
    }

    private DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
    private float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
    private float dpWidth  = displayMetrics.widthPixels / displayMetrics.density;

    private static final String LOG_TAG = MovieView.class.getSimpleName();

    /** Inherited constructor. */
    public MovieView(Context context) {
        super(context);
    }

    /** Inherited constructor. */
    public MovieView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /** Inherited constructor. */
    public MovieView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mImageView = (ImageView) findViewById(R.id.grid_item_imageview);
    }

    public void showMovie(Movie movie) {
        String path = movie.getPosterPath();
        // String name = movie.getTitle();

        if (path != null) {
            path = path.replaceFirst("/", "");

            Uri uri = Uri.parse(MOVIE_BASE_URL).buildUpon()
                    .appendPath(SIZE)
                    .appendPath(path)
                    .build();

            Picasso.with(getContext()).load(uri).placeholder(R.drawable.placeholder).into(mImageView);
        } else {
            Picasso.with(getContext()).load(R.drawable.placeholder).into(mImageView);
        }
    }
}
