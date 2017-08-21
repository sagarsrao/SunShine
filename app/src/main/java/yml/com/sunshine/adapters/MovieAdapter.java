package yml.com.sunshine.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import yml.com.sunshine.R;

/**
 * Created by sagar on 21/8/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    Context context;


    ArrayList<yml.com.sunshine.model.Movie> movieList;

    public MovieAdapter(Context context, ArrayList<yml.com.sunshine.model.Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
        movieList = new ArrayList<>();
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weather, parent, false);


        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {


        /*Use Glide to load the View from the network*/
        Glide.with(context)
                .load(movieList.get(position).getMoviePoster_path())
                .into(holder.movieImage);

        holder.movieTitle.setText(movieList.get(position).getMovieTitle());
        holder.movieOverView.setText(movieList.get(position).getMovieoverview());
        holder.movieVoteAverage.setText(movieList.get(position).getMovieVoteCount());







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


        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            movieImage =  itemView.findViewById(R.id.imageView_movie);

            movieTitle = itemView.findViewById(R.id.textView_title);

            movieOverView = itemView.findViewById(R.id.textView_overview);

            movieVoteAverage = itemView.findViewById(R.id.textView_voteAverage);




        }
    }
}
