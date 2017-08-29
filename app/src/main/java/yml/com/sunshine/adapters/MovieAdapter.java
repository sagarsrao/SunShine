package yml.com.sunshine.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yml.com.sunshine.R;
import yml.com.sunshine.activities.MovieDetailsActivity;
import yml.com.sunshine.constants.Constants;
import yml.com.sunshine.model.Movie;

/**
 * Created by sagar on 21/8/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    Context context;


    Movie movie;

    List<yml.com.sunshine.model.Movie> movieList = new ArrayList<>();


    public MovieAdapter(Context context, List<yml.com.sunshine.model.Movie> movieList) {
        this.context = context;
        this.movieList = movieList;

    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, parent, false);


        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, final int position) {


        String posterUrl = Constants.POSTER_URL + movieList.get(position).getPoster_path();
        /*Use Picasso to load the View from the network*/
        Picasso.with(context)
                .load(posterUrl)
                .into(holder.movieImage);

        holder.movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMovieDetailsActivity = new Intent(context, MovieDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("POSTER_PATH", movieList.get(position).getPoster_path());
                bundle.putString("MOVIE_TITLE", movieList.get(position).getTitle());
                bundle.putString("MOVIE_OVERVIEW", movieList.get(position).getOverview());

                bundle.putString("MOVIE_VOTE_COUNT", movieList.get(position).getVote_count());
                bundle.putString("MOVIE_RELEASE_DATE", movieList.get(position).getRelease_date());
                bundle.putString("MOVIE_POPULARITY", movieList.get(position).getPopularity());
                gotoMovieDetailsActivity.putExtras(bundle);

                context.startActivity(gotoMovieDetailsActivity);


            }
        });

    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView_movie)
        ImageView movieImage;

        @BindView(R.id.textView_title)
        TextView movieTitle;

        @BindView(R.id.textView_overview)
        TextView movieOverView;

        @BindView(R.id.textView_voteAverage)
        TextView movieVoteAverage;

        @BindView(R.id.textView_release_Date)
        TextView movieReleaseDate;

        @BindView(R.id.textView_popularity)
        TextView moviePopularity;


        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            movieImage = itemView.findViewById(R.id.imageView_movie);
            movieTitle = itemView.findViewById(R.id.textView_title);
            movieOverView = itemView.findViewById(R.id.textView_overview);
            movieVoteAverage = itemView.findViewById(R.id.textView_voteAverage);
            movieReleaseDate = itemView.findViewById(R.id.textView_release_Date);
            moviePopularity = itemView.findViewById(R.id.textView_popularity);


        }
    }
}
