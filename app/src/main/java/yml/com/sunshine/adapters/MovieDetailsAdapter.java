package yml.com.sunshine.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yml.com.sunshine.R;
import yml.com.sunshine.constants.Constants;
import yml.com.sunshine.model.Movie;

/**
 * Created by sagar on 28/8/17.
 */


/*This adapter will  have the data for youtube videos and the movie related stuff which has to be used for horizontal recyclerView
* The item list to be used for this is list_horizontal_movies*/
public class MovieDetailsAdapter extends RecyclerView.Adapter<MovieDetailsAdapter.MyViewHolder> {


    Context mContext;


    List<Movie> movieList;

    public MovieDetailsAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public MovieDetailsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_horizontal_movies, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieDetailsAdapter.MyViewHolder holder, int position) {

/*
        Intent intent = new Intent();
        Bundle bundle = intent.getExtras();

        String posterPath = Constants.POSTER_URL + bundle.getString("POSTER_PATH");
        Picasso.with(mContext)
                .load(posterPath)
                .into(holder.tvPosterImage);

        String title = bundle.getString("MOVIE_TITLE");
        holder.tvTitle.setText("MovieTitle:" + title);
        holder.tvTitle.setTextColor(Color.BLACK);

        String releaseDate = bundle.getString("MOVIE_RELEASE_DATE");
        holder.tvReleaseDate.setText("ReleaseDate:" + releaseDate);
        holder.tvReleaseDate.setTextColor(Color.BLACK);

        String overView = bundle.getString("MOVIE_OVERVIEW");
        holder.tvOverView.setText("OverView:" + overView);
        holder.tvOverView.setTextColor(Color.BLACK);

        String voteCount = bundle.getString("MOVIE_VOTE_COUNT");
        holder.tvVoteCount.setText("MovieVoteCount:" + voteCount);
        holder.tvVoteCount.setTextColor(Color.BLACK);


        String popularity = bundle.getString("MOVIE_POPULARITY");
        holder.tvPopularuty.setText("MoviePopularity:" + popularity);
        holder.tvPopularuty.setTextColor(Color.BLACK);*/


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


       /* @BindView(R.id.imagePoster)
        ImageView tvPosterImage;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_releaseDate)
        TextView tvReleaseDate;

        @BindView(R.id.tv_overView)
        TextView tvOverView;


        @BindView(R.id.tv_voteCount)
        TextView tvVoteCount;

        @BindView(R.id.tv_popularity)
        TextView tvPopularuty;
*/

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
