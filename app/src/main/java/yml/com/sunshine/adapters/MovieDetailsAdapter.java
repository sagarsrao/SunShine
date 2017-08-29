package yml.com.sunshine.adapters;

import android.content.Context;
import android.graphics.Color;
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


        String posterPath = movieList.get(position).getPoster_path();
        Picasso.with(mContext)
                .load(posterPath)
                .into(holder.tvPosterImage);


        holder.tvTitle.setText("Title:" + movieList.get(position).getTitle());
        holder.tvTitle.setTextColor(Color.BLACK);


        holder.tvReleaseDate.setText("RelDate:" + movieList.get(position).getRelease_date());
        holder.tvReleaseDate.setTextColor(Color.BLACK);


        holder.tvPopularity.setText("Popularity:" + movieList.get(position).getPopularity());
        holder.tvPopularity.setTextColor(Color.BLACK);


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.imagePoster)
        ImageView tvPosterImage;

        @BindView(R.id.tv_movieName)
        TextView tvTitle;

        @BindView(R.id.tv_movieReleaseDate)
        TextView tvReleaseDate;


        @BindView(R.id.moviePopularity)
        TextView tvPopularity;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
