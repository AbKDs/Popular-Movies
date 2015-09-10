package com.gmail.abhishekdas1503.email.popularmovies;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.abhishekdas1503.email.popularmovies.model.Movie;

/**
 * A custom implementaion of a view which extends from a LinearLayout
 * and is helps in avoid ViewHolder class by saving the views in the
 * member variables
 */
public class MovieView extends LinearLayout {

    private ImageView mImageView;

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
        String movieName = movie.getName();

        mImageView.setImageBitmap(poster);
    }
}
