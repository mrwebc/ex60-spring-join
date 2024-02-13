package ver8_JavaMultiConf;

import java.text.SimpleDateFormat;

import exception.MemberNotFoundException;

public class MemberPrinter {
  
  //단일회원
  public void printInfo(MemberDTO m) {
    
    if(m==null) {
//      System.out.println("이메일에 해당하는 회원정보가 없습니다.");
//      return;
      
        throw new MemberNotFoundException("이메일에 해당하는 회원정보가 없습니다.");
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println("회원정보 : 아이디="+m.getId()+", 이메일:"+m.getEmail()+", 이름:"+m.getName()+", 암호:"+m.getPwd()+", 등록일:"+sdf.format(m.getRegDate()));
    
  }
  
  //전체회원
  public void printInfo(MemberDTO m, int no) {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    System.out.println(no+". 아이디:"+m.getId()+", 이메일:"+m.getEmail()+", 등록일:"+sdf.format(m.getRegDate()));
  }  
}
