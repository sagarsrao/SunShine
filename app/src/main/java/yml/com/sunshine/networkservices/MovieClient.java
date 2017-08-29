package yml.com.sunshine.networkservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static yml.com.sunshine.constants.Constants.BASE_URL;

/**
 * Created by sagar on 22/8/17.
 */

public class MovieClient {

    private MovieClient() {
    }

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
