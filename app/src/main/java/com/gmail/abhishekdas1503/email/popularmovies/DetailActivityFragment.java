package com.gmail.abhishekdas1503.email.popularmovies;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.abhishekdas1503.email.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

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

        ImageView poster = (ImageView) rootView.findViewById(R.id.poster);
        String path = movie.getPosterPath();
        if (path != null) {
            path = path.replaceFirst("/", "");

            Uri uri = Uri.parse(MovieView.MOVIE_BASE_URL).buildUpon()
                    .appendPath(MovieView.SIZE)
                    .appendPath(path)
                    .build();

            Picasso.with(getActivity()).load(uri).placeholder(R.drawable.placeholder).into(poster);
        } else {
            Picasso.with(getActivity()).load(R.drawable.placeholder).into(poster);
        }


        TextView release = (TextView) rootView.findViewById(R.id.release);
        release.setText(movie.getReleaseDate().substring(0, 4));

        TextView vote = (TextView) rootView.findViewById(R.id.vote);
        vote.setText(movie.getVoteAverage() + "/10");

        TextView synopsis = (TextView) rootView.findViewById(R.id.synopsis);
        synopsis.setText(movie.getOverview());

        return rootView;
    }
}
