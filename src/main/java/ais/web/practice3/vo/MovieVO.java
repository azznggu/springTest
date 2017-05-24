package ais.web.practice3.vo;

import org.springframework.web.multipart.MultipartFile;

public class MovieVO {
	private String userId;
	private int movie_no;
	private String movie_title;
	private String movie_director;
	private String movie_actor;
	private String movie_genre;
	private String originalfile;
	private String savedfile;
	private MultipartFile file;

	public MovieVO() {
	}

	public MovieVO(String userId, int movie_no, String movie_title, String movie_director, String movie_actor,
			String movie_genre, String originalfile, String savedfile, MultipartFile file) {
		super();
		this.userId = userId;
		this.movie_no = movie_no;
		this.movie_title = movie_title;
		this.movie_director = movie_director;
		this.movie_actor = movie_actor;
		this.movie_genre = movie_genre;
		this.originalfile = originalfile;
		this.savedfile = savedfile;
		this.file = file;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getOriginalfile() {
		return originalfile;
	}

	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	public String getSavedfile() {
		return savedfile;
	}

	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}


	@Override
	public String toString() {
		return "MovieVO [userId=" + userId + ", movie_no=" + movie_no + ", movie_title=" + movie_title
				+ ", movie_director=" + movie_director + ", movie_actor=" + movie_actor + ", movie_genre=" + movie_genre
				+ ", originalfile=" + originalfile + ", savedfile=" + savedfile + ", file=" + file + "]";
	}

}
