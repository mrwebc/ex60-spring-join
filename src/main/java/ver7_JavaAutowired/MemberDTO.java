package ver7_JavaAutowired;
import java.util.Date;

import exception.PasswordNotMatchingException;

public class MemberDTO {
	private int id;
	private String name;
	private String email;
	private String pwd;
	private Date regDate;
	
	public MemberDTO() {}
	

	public MemberDTO(String email, String name,  String pwd, Date regDate) {
		super();
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.regDate = regDate;
	}


	//암호변경
	public void changePwd(String oldPwd, String newPwd) {	

		if(this.pwd.equals(oldPwd)) {
			this.pwd = newPwd;	
		}else {
		  throw new PasswordNotMatchingException("입력한 암호가 등록되어 있는 암호와 일치하지 않습니다.");
			//System.out.println("입력한 암호가 등록되어 있는 암호와 일치하지 않습니다.");
		}
	}//end of changePwd
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPwd() {
		return pwd;
	}




	public void setPwd(String pwd) {
		this.pwd = pwd;
	}




	public Date getRegDate() {
		return regDate;
	}




	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


}
