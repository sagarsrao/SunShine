package yml.com.sunshine.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yml.com.sunshine.R;

import yml.com.sunshine.adapters.MovieAdapter;
import yml.com.sunshine.model.Movie;
import yml.com.sunshine.networkservices.MovieClient;
import yml.com.sunshine.networkservices.MovieInterface;

import static yml.com.sunshine.constants.Constants.POPULAR_MOVIE_API_KEY;


/**
 * Created by sagar on 21/8/17.
 */

public class MovieFragment extends Fragment {


    public static final String TAG = "MovieFragment";

    @BindView(R.id.my_weather_recycler_view)
    RecyclerView mRecyclerView;

    private LinearLayoutManager linearLayoutManager;


    ArrayList<Movie> listMovie;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this, view);

        /*Make the retrofit call to load the json response*/
        linearLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        MovieInterface movieInterface = MovieClient.getClient().create(MovieInterface.class);

        Call<Movie> movieCall = movieInterface.getMovieResponse(POPULAR_MOVIE_API_KEY);

        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                listMovie = (ArrayList<Movie>) response.body().getMovieResults();
                if (response.isSuccessful()) {
                    try {
                        mRecyclerView.setAdapter(new MovieAdapter(getContext(), listMovie));
                    } catch (Exception e) {

                        Log.d(TAG, "onResponse: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

                Toast.makeText(getActivity(), getString(R.string.network_failure) + t, Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }
}

