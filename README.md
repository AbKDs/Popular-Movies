Popular-Movies
==========

An Android App which which uses the movieDB database to show the details 
about current movies.

Usage
--------
Currently I don't have any intent to make it a production app. In the code 
you need to have your own API key provided by TMDB. So to build the apk 
include in the app/src/main/java/com/gmail/abhishekdas1503/email/popularmovies
a file named `ApiKey.java` which contains nothing but a constant `API_KEY`.

Your `ApiKey.java` should look like : 
```
package com.gmail.abhishekdas1503.email.popularmovies;

/**
 * A class that encapsulates the API_KEY
 */
public class ApiKey {
    public static final String API_KEY = /* Your API KEY here */ ;
}
```

After adding this file you can build the app and install it on your device.
