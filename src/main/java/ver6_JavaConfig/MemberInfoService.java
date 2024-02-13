package ver6_JavaConfig;

import exception.MemberNotFoundException;

public class MemberInfoService {

  private MemberDAO dao;
  private MemberPrinter mp;
  
  public MemberInfoService(MemberDAO dao) {
    this.dao = dao;
  }
  
  public void setMp(MemberPrinter mp) {
    this.mp = mp;
  }
  
  
  //단일회원 정보출력
  public void printMember(String email) {   
    MemberDTO m = dao.selectedByEmail(email);
    try {
      mp.printInfo(m);
    }catch(MemberNotFoundException e) {
      System.out.println(e.getMessage());
    }
    
  }  
  
}
