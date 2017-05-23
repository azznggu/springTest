package ais.web.practice3.vo;

public class UserVO {
	private String userId;
	private String userPassword;
	private String userName;
	private String userPhone;

	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(String userId, String userPassword, String userName, String userPhone) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", userPhone="
				+ userPhone + "]";
	}

}
