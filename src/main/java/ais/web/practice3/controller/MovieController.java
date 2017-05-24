package ais.web.practice3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ais.web.practice3.persistence.MovieDAO;
import ais.web.practice3.persistence.UserDAO;
import ais.web.practice3.vo.MovieVO;
import ais.web.practice3.vo.UserVO;

@Controller
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	SqlSession sqlSession;

	@RequestMapping(value = "/movieList", method = RequestMethod.GET)
	public String movieList(Model model) {
		logger.info("movieList!");
		MovieDAO dao = sqlSession.getMapper(MovieDAO.class);
		try {
			List<MovieVO> movieList = dao.showMovieInfoList();
			model.addAttribute("movieList", movieList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "movieList";
	}

	@RequestMapping(value = "/writeMovie", method = RequestMethod.GET)
	public String writeMovie() {
		return "writeMovie";
	}

	@RequestMapping(value = "/writeMovie", method = RequestMethod.POST)
	public String writeMovie(MovieVO movie, Model model, HttpServletRequest request) {
		logger.info("writeMovie insert data: " + movie.toString());
		String returnMessage = null;
		String userId= (String) request.getSession().getAttribute("userId");
		logger.info(userId);
		movie.setUserId(userId);
		MovieDAO dao = sqlSession.getMapper(MovieDAO.class);
		try {
			int result = dao.insertMovie(movie);
			if (result != 0) {
				returnMessage = "redirect:movieList";
			} else {
				returnMessage = "writeMovie";
				model.addAttribute("movie", movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMessage;
	}

	@RequestMapping(value = "/movieDetail", method = RequestMethod.GET)
	public String movieDetail(String movie_no, Model model) {
		MovieDAO dao = sqlSession.getMapper(MovieDAO.class);
		try {
			MovieVO movie = dao.selectMovie(Integer.parseInt(movie_no));
			logger.info("detail: " + movie.toString());
			model.addAttribute("movie", movie);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "movieDetail";
	}

	@RequestMapping(value = "/updateMovie", method = RequestMethod.POST)
	public String updateMovie() {
		logger.info("update");
		return "movieDetail";
	}

	@RequestMapping(value = "deleteMovie", method = RequestMethod.POST)
	public String deleteMovie(String movie_no) {
		logger.info("delete");
		MovieDAO dao = sqlSession.getMapper(MovieDAO.class);
		try {
			dao.deleteMovie(Integer.parseInt(movie_no));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:movieList";

	}
}
