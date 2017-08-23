package yml.com.sunshine.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import yml.com.sunshine.R;
import yml.com.sunshine.constants.Constants;

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

        String title = bundle.getString("MOVIE_TITLE");
        movieTitle.setText(title);

        String date = bundle.getString("MOVIE_RELEASE_DATE");
        movieReleaseDate.setText(date);

        String overView = bundle.getString("MOVIE_OVERVIEW");
        movieOverView.setText(overView);

        String voteCount = bundle.getString("MOVIE_VOTE_COUNT");
        movieVoteAverage.setText(voteCount);

        String popularity = bundle.getString("MOVIE_POPULARITY");
        moviePopularity.setText(popularity);


    }
}
