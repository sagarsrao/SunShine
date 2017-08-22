package yml.com.sunshine.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Movie;
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
import yml.com.sunshine.constants.Constants;

/**
 * Created by sagar on 21/8/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    Context context;


    List<yml.com.sunshine.model.Movie> movieList = new ArrayList<>();


    public MovieAdapter(Context context, List<yml.com.sunshine.model.Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weather, parent, false);


        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {


        String posterUrl = Constants.POSTER_URL + movieList.get(position).getPoster_path();
        /*Use Picasso to load the View from the network*/
        Picasso.with(context)
                .load(posterUrl)
                .into(holder.movieImage);





        /*holder.movieTitle.setText(movieList.get(position).getTitle());
        holder.movieTitle.setTextColor(Color.BLACK);
        holder.movieOverView.setText(movieList.get(position).getOverview());
        holder.movieOverView.setTextColor(Color.BLUE);
        holder.movieVoteAverage.setText(movieList.get(position).getVote_count());
        holder.movieVoteAverage.setTextColor(Color.RED);
*/
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView_movie)
        ImageView movieImage;

       /* @BindView(R.id.textView_title)
        TextView movieTitle;

        @BindView(R.id.textView_overview)
        TextView movieOverView;

        @BindView(R.id.textView_voteAverage)
        TextView movieVoteAverage;*/


        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            movieImage = itemView.findViewById(R.id.imageView_movie);

           /* movieTitle = itemView.findViewById(R.id.textView_title);

            movieOverView = itemView.findViewById(R.id.textView_overview);

            movieVoteAverage = itemView.findViewById(R.id.textView_voteAverage);*/


        }
    }
}
