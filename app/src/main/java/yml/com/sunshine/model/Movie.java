package yml.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sagar on 21/8/17.
 */

public class Movie {


    @SerializedName("poster_path")
    String poster_path;

    @SerializedName("overview")
    String overview;

    @SerializedName("title")
    String title;


    @SerializedName("vote_count")
    String vote_count;


    @SerializedName("release_date")
    String release_date;


    @SerializedName("popularity")
    String popularity;

    @SerializedName("results")
    private List<Movie> movieResults;


    public List<Movie> getMovieResults() {
        return movieResults;
    }

    public void setMovieResults(List<Movie> movieResults) {
        this.movieResults = movieResults;
    }

    public Movie(String poster_path, String overview, String title, String vote_count, String release_date, String popularity) {
        this.poster_path = poster_path;
        this.overview = overview;
        this.title = title;
        this.vote_count = vote_count;
        this.release_date = release_date;
        this.popularity = popularity;
    }


    public Movie(String poster_path, String title, String release_date, String popularity) {
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
        this.popularity = popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }
}
