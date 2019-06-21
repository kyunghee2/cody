package spring.biz.user.vo;

public class UserVO {
	private String userid;
	private String name;
	private String userpwd;
	private String email;
	private String phone;
	private String gender;
	
	public UserVO() {
		super();
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserVO(String userid, String name, String userpwd, String email, String phone, String gender) {
		super();
		this.userid = userid;
		this.name = name;
		this.userpwd = userpwd;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", name=" + name + ", userpwd=" + userpwd + ", email=" + email + ", phone="
				+ phone + ", gender=" + gender + "]";
	}	
}
