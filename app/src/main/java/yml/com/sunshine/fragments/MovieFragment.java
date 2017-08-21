package yml.com.sunshine.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndJSONArrayRequestListener;
//import com.jacksonandroidnetworking.JacksonParserFactory;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;
import yml.com.sunshine.R;
import yml.com.sunshine.adapters.MovieAdapter;
import yml.com.sunshine.model.Movie;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by sagar on 21/8/17.
 */

public class MovieFragment extends Fragment {


    @BindView(R.id.my_weather_recycler_view)
    RecyclerView mRecyclerView;

    ArrayList<Movie> listMovie;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Instantiating the library
        AndroidNetworking.initialize(getActivity());

        //Instantiating the json parser factory
        //AndroidNetworking.setParserFactory(new JacksonParserFactory());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moview, container, false);
        ButterKnife.bind(this, view);

        /*https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=b6b7a875d978c3b553d11ffae6765aee
*/
        listMovie = new ArrayList<>();


        AndroidNetworking.get("https://api.themoviedb.org/3/discover/movie")
                .addQueryParameter("sort_by", "popularity.desc")
                .addQueryParameter("api_key", "b6b7a875d978c3b553d11ffae6765aee")
                .setPriority(Priority.HIGH)
                .build()
                /*.getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // do anything with response


                        try {
                            Log.d(TAG, "onResponse: "+response);

                            String posterPath = response.getJSONObject(0).getString("poster_path");

                            String movieTitle = response.getJSONObject(1).getString("title");

                            String movieOverView = response.getJSONObject(2).getString("overview");

                            String movieAverage = response.getJSONObject(3).getString("vote_count");


                            Movie movie = new Movie(posterPath, movieOverView, movieTitle, movieAverage);

                            listMovie.add(movie);

                            mRecyclerView.setAdapter(new MovieAdapter(getActivity(), listMovie));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error

                        Log.d(TAG, "onError: "+error.getMessage());

                        Toast.makeText(getContext(), "Network Failure in fetching the movies"+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
*/


                .getAsOkHttpResponseAndJSONArray(new OkHttpResponseAndJSONArrayRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, JSONArray response) {

                        Log.d(TAG, "onResponse: "+response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "onError: "+anError.getMessage());

                    }
                });
        return view;


    }
}
