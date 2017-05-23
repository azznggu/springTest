package ais.web.practice3.persistence;

import java.util.List;

import ais.web.practice3.vo.MovieVO;

public interface MovieDAO {
	public List<MovieVO> showMovieInfoList() throws Exception;
	
}
