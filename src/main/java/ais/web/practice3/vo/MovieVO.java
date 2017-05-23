package ais.web.practice3.vo;

public class MovieVO {
	private int movie_no;
	private String movie_title;
	private String movie_director;
	private String movie_actor;
	private String movie_genre;

	public MovieVO() {
	}

	public MovieVO(int movie_no, String movie_title, String movie_director, String movie_actor, String movie_genre) {
		super();
		this.movie_no = movie_no;
		this.movie_title = movie_title;
		this.movie_director = movie_director;
		this.movie_actor = movie_actor;
		this.movie_genre = movie_genre;
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getMovie_director() {
		return movie_director;
	}

	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}

	public String getMovie_actor() {
		return movie_actor;
	}

	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	@Override
	public String toString() {
		return "MovieVO [movie_no=" + movie_no + ", movie_title=" + movie_title + ", movie_director=" + movie_director
				+ ", movie_actor=" + movie_actor + ", movie_genre=" + movie_genre + "]";
	}

}
