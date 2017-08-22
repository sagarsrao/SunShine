package yml.com.sunshine.networkservices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yml.com.sunshine.model.Movie;

/**
 * Created by sagar on 22/8/17.
 */

public interface MovieInterface {

    @GET("/3/movie/upcoming")
    Call<Movie> getMovieResponse(
            // @Query("sort_by") String sort_by,
            @Query("api_key") String api_Key

    );


}
