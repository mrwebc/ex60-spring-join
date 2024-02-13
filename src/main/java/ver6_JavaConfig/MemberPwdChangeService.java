package ver6_JavaConfig;

import exception.MemberNotFoundException;

public class MemberPwdChangeService {
  private MemberDAO dao;
  
  public MemberPwdChangeService(MemberDAO dao) {
    this.dao = dao;
  }

  //입력한 이메일과 일치하는 회원정보 
  public MemberDTO existMember(String email) {
    return dao.selectedByEmail(email);
  }


  public void changePwd(String email, String oldPwd, String newPwd) {

    //입력한 이메일에 해당하는 정보 유무 확인
    MemberDTO memDto =  dao.selectedByEmail(email);
    
    if(memDto==null) {
      throw new MemberNotFoundException("이메일에 해당하는 회원정보가 없습니다.");
  }    
    
    //암호를 변경
    memDto.changePwd(oldPwd, newPwd);
  
    //Map 저장소에 업데이트
    dao.updatePwd(memDto); 
    
    
  }
  
  
}
