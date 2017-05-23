package ais.web.practice3.persistence;

import ais.web.practice3.vo.UserVO;

public interface UserDAO {
	public int insertUser(UserVO user) throws Exception;
	public UserVO loginCheck(UserVO user) throws Exception;
	public UserVO idCheck(String userId) throws Exception;
}
