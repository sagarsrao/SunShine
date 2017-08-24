package yml.com.sunshine.networkservices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yml.com.sunshine.model.Movie;

/**
 * Created by sagar on 22/8/17.
 */

public interface MovieInterface {


    /*The below API We use it for POP movies*/
    @GET("/3/movie/upcoming")
    Call<Movie> getMovieResponse(
            // @Query("sort_by") String sort_by,
            @Query("api_key") String api_Key

    );


    /*The below API we use it for latestMovies */
    @GET("/3/movie/now_playing")
    Call<Movie> getMovieResponseNowPlaying(
            // @Query("sort_by") String sort_by,
            @Query("api_key") String api_Key

    );


    /*The below API we use it for TopRated  Movies*/
    @GET("/3/movie/top_rated")
    Call<Movie> getMovieResponseTopRatedMovies(
            // @Query("sort_by") String sort_by,
            @Query("api_key") String api_Key

    );

}
