package com.gmail.abhishekdas1503.email.popularmovies.network;
import com.gmail.abhishekdas1503.email.popularmovies.model.MovieResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Movie API interface for the retrofit library. This interface helps in
 * downloading the json data from the movieDB website.
 */

public interface TMovieDBService {
    @GET("/movie")
    void getMovieResponse(@Query("sort_by") String sortKey,
/*                          @Query("certification_country") String country,
                          @Query("certification") String certify,*/
//                          @Query("vote_count.gte") String votes,
                          @Query("api_key") String apiKey,

                          Callback<MovieResponse> response);
}