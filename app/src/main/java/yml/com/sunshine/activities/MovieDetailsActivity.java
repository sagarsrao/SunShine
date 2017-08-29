package yml.com.sunshine.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yml.com.sunshine.R;
import yml.com.sunshine.adapters.MovieDetailsAdapter;
import yml.com.sunshine.constants.Constants;
import yml.com.sunshine.model.Movie;

/**
 * Created by sagar on 23/8/17.
 */

public class MovieDetailsActivity extends AppCompatActivity {


    @BindView(R.id.imagePoster)
    ImageView mPosterImage;

    @BindView(R.id.text_MovieName)
    TextView movieTitle;


    @BindView(R.id.text_Movie_Release_Date)
    TextView movieReleaseDate;


    @BindView(R.id.text_Movie_OverView)
    TextView movieOverView;

    @BindView(R.id.text_movie_count)
    TextView movieVoteAverage;

    @BindView(R.id.text_movie_popularity)
    TextView moviePopularity;


    @BindView(R.id.my_HorizontalRecyclerView)
    RecyclerView myHorizontalRecyclerView;


    List<Movie> movieList;

    Movie movie;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetails);
        ButterKnife.bind(this);

        initTheToolBar();


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initTheToolBar() {
        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolBar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        myToolBar.setTitle("PopularMovies");
        myToolBar.setTitleTextColor(Color.WHITE);
        myToolBar.setBackgroundColor(getColor(R.color.colorPrimary));
        setSupportActionBar(myToolBar);
        movieList = new ArrayList<>();


        myToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MovieDetailsActivity.this, MovieActivity.class));
            }
        });

        setTheMovieViews();
    }

    private void setTheMovieViews() {

        Bundle bundle = getIntent().getExtras();


        String posterPath = Constants.POSTER_URL + bundle.getString("POSTER_PATH");
        Picasso.with(getApplicationContext())
                .load(posterPath)
                .into(mPosterImage);
        String posterPath1 = posterPath;
//        movie.setPoster_path(posterPath1); //take it to the list

        String title = bundle.getString("MOVIE_TITLE");
        movieTitle.setText("Title:" + title);
        movieTitle.setTextColor(Color.BLACK);

        String title1 = title;
        String date = bundle.getString("MOVIE_RELEASE_DATE");
        movieReleaseDate.setText("ReleaseDate:" + date);
        movieReleaseDate.setTextColor(Color.BLACK);

        String date1 = date;
        //movie.setRelease_date(date);


        String overView = bundle.getString("MOVIE_OVERVIEW");
        movieOverView.setText("Overview:" + overView);
        movieOverView.setTextColor(Color.BLACK);

        String voteCount = bundle.getString("MOVIE_VOTE_COUNT");
        movieVoteAverage.setText("VoteCount:" + voteCount);
        movieVoteAverage.setTextColor(Color.BLACK);

        String popularity = bundle.getString("MOVIE_POPULARITY");
        moviePopularity.setText("Popularity:" + popularity);
        moviePopularity.setTextColor(Color.BLACK);
        String popularity1 = popularity;

        movie = new Movie(posterPath1, title1, date1, popularity1);

        movieList.add(movie);

        myHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        myHorizontalRecyclerView.setAdapter(new MovieDetailsAdapter(MovieDetailsActivity.this, movieList));


    }
}
