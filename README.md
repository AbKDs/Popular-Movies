Popular-Movies
==========

An Android App which which uses the movieDB database to show the details 
about current movies.

Usage
--------
Currently I don't have any intent to make it a production app. In the code 
you need to have your own API key provided by TMDB. So to build the apk 
in the `app/src/main/java/com/gmail/abhishekdas1503/email/popularmovies`
in `MovieFragment.java` which contains a constant `API_KEY`.

`MovieFragment.java` should look like : 
```
...
/**
 * Encapsulates fetching the movie details and displaying it as {@link GridView} layout
 */
public class MovieFragment extends Fragment {
    public static final String API_KEY = /* YOUR API KEY HERE */;
    
    private MovieAdapter mMovieAdapter;
...
```

Update it with your key and build.
