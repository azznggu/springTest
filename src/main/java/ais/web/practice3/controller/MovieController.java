package ais.web.practice3.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	// SPEL식으로 이미지 저장할 디스크 상의 위치를 읽어 변수에 저장
	@Value("#{file['imgPath']}")
	String path;

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
		String returnMessage = null;
		String userId = (String) request.getSession().getAttribute("userId");

		if (!movie.getFile().isEmpty()) {
			// 두 가지 정보 필요 : DB에 저장할 파일명과 원본의 물리 파일명
			// 사용자 마다 같은 이름의 이미지를 업로드 할 수 있으므로 이름 변경을 위해 ID생성
			UUID uid = UUID.randomUUID();
			// DB에 저장할 파일명과 변경된 파일명
			String originalFile = movie.getFile().getOriginalFilename();
			String savedFile = uid.toString() + "_" + originalFile;

			// 물리 폴더 경로(업로드할 위치)
			System.out.println(originalFile);
			System.out.println("path : " + path);
			File directory = new File(path);
			
			// 해당 경로에 대한 디렉토리가 존재하지 않으면 생성
			if (!directory.exists()) { 
				directory.mkdirs();
			}
			
			// 실제로 저장할 파일명과 경로
			String fpath = path + "\\" + savedFile; 
			
			FileOutputStream fs;
			try {
				fs = new FileOutputStream(fpath);
				try {
					fs.write(movie.getFile().getBytes());
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			//저장 경로에 업로드 작업 후에 DB저장 전 VO에 원본파일명 및 실제저장파일명을 SET
			movie.setOriginalfile(originalFile);
			movie.setSavedfile(savedFile);
		}

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
	public String updateMovie(MovieVO movie) {
		logger.info("update");
		String returnMessage = null;
		MovieDAO dao = sqlSession.getMapper(MovieDAO.class);
		try {
			int result = dao.updateMovie(movie);
			if (result != 0) {
				returnMessage = "redirect:movieList";
			} else {
				// 업데이트 실패 시..
				returnMessage = "redirect:movieList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMessage;
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
