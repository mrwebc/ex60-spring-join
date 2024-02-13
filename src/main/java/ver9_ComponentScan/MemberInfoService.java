package ver9_ComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import exception.MemberNotFoundException;

@Service("infoService")
public class MemberInfoService {

  @Autowired private MemberDAO dao;
  @Autowired @Qualifier("mPrinter") private MemberPrinter mp;
  
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
