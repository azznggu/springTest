package ais.web.practice3.persistence;

import java.util.List;

import ais.web.practice3.vo.MovieVO;

public interface MovieDAO {
	public List<MovieVO> showMovieInfoList() throws Exception;
	public int insertMovie(MovieVO movie) throws Exception;
	public MovieVO selectMovie(int movie_no) throws Exception;
}
