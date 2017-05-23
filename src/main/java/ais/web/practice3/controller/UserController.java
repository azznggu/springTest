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
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	SqlSession sqlSession;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 화면.");
		return "join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO user) {
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

	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public @ResponseBody String idCheck(String userId) {
		System.out.println(userId);
		String message = "fail";
		UserDAO dao = sqlSession.getMapper(UserDAO.class);
		try {
			UserVO existVo = dao.idCheck(userId);
			if (existVo == null) {
				message = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO user, HttpSession session) {
		logger.info(user.toString());
		UserDAO dao = sqlSession.getMapper(UserDAO.class);
		try {
			UserVO resultUser = dao.loginCheck(user);
			if (resultUser != null) {
				if (resultUser.getUserPassword().equals(user.getUserPassword())) {
					session.setAttribute("userId", resultUser.getUserId());
					session.setAttribute("userName", resultUser.getUserName());
					logger.info("login success and Info added into session.");
					return "index";
				} else {
					logger.info("not the same user data.");
				}
			} else {
				logger.info("resultUser is null.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		logger.info("user logout.");
		return "index";
	}
}
