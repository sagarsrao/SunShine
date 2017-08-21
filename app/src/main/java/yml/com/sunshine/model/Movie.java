package yml.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sagar on 21/8/17.
 */

public class Movie  {


  @SerializedName("poster_path")
  String moviePoster_path;

  @SerializedName("overview")
  String movieoverview;

  @SerializedName("title")
  String movieTitle;


  @SerializedName("vote_count")
  String movieVoteCount;


  public Movie(String moviePoster_path, String movieoverview, String movieTitle, String movieVoteCount) {
    this.moviePoster_path = moviePoster_path;
    this.movieoverview = movieoverview;
    this.movieTitle = movieTitle;
    this.movieVoteCount = movieVoteCount;
  }

  public String getMoviePoster_path() {
    return moviePoster_path;
  }

  public void setMoviePoster_path(String moviePoster_path) {
    this.moviePoster_path = moviePoster_path;
  }

  public String getMovieoverview() {
    return movieoverview;
  }

  public void setMovieoverview(String movieoverview) {
    this.movieoverview = movieoverview;
  }

  public String getMovieTitle() {
    return movieTitle;
  }

  public void setMovieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
  }

  public String getMovieVoteCount() {
    return movieVoteCount;
  }

  public void setMovieVoteCount(String movieVoteCount) {
    this.movieVoteCount = movieVoteCount;
  }
}
