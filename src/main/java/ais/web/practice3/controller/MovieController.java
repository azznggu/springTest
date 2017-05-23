package ais.web.practice3.controller;

import java.util.List;

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
			for (MovieVO m : movieList) {
				logger.info(m.toString());
			}
			model.addAttribute("movieList", movieList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "movieList";
	}

}
