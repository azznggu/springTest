package ais.web.practice3.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ais.web.practice3.persistence.UserDAO;
import ais.web.practice3.vo.UserVO;

@Controller
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value = "/movieList", method = RequestMethod.GET)
	public String movieList() {
		logger.info("movieList!");
		return "movieList";
	}
	
	@RequestMapping(value = "/movieList", method = RequestMethod.POST)
	public String movieList(UserVO user) {
		logger.info(user.toString());
		logger.info(sqlSession.toString());
		UserDAO dao = sqlSession.getMapper(UserDAO.class);
		try {
			int result = dao.insertUser(user);
			if (result != 0) {
				logger.info("가입 성공.");
			} else {
				logger.info("가입 실패.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	

	

}
