package com.gmail.abhishekdas1503.email.popularmovies;

import android.graphics.Bitmap;

/**
 * Moive class whose object will store the name of the movie
 * and bitmap (poster) downloaded from the movieDB database.
 */
public class Movie {
    private Bitmap mPoster;
    private String mName;

    public Movie(Bitmap mPoster, String mName) {
        this.mPoster = mPoster;
        this.mName = mName;
    }

    public Bitmap getPoster() {
        return mPoster;
    }

    public void setPoster(Bitmap mPoster) {
        this.mPoster = mPoster;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}
