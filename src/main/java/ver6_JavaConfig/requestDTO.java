package ver6_JavaConfig;

public class requestDTO {
	
	private String email;
	private String name;
	private String pwd;
	private String confirmPwd;

	public requestDTO(String email, String name, String pwd, String confirmPwd) {
		this.email=email;
		this.name=name;
		this.pwd=pwd;
		this.confirmPwd = confirmPwd;
	}
	

	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getConfirmPwd() {
		return confirmPwd;
	}



	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}



	//동일암호 입력확인
	public Boolean comparePwd() {
		return pwd.equals(confirmPwd);
	}

}
