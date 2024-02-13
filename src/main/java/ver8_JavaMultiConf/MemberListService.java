package ver8_JavaMultiConf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import exception.MemberNotFoundException;

public class MemberListService {

	private MemberDAO dao;
  private MemberPrinter mp;
	
	@Autowired
	public void setDao(MemberDAO dao) {
	  this.dao = dao;
	}
	
	@Autowired
  public void setMp(MemberPrinter mp) {
    this.mp = mp;
  }	
	
	//전체회원 정보출력
	public void printMemberList() {
		
		Collection<MemberDTO> memList = dao.getList();
		
		if(memList.size()==0) {
		  System.out.println("현재 등록된 회원정보가 없습니다.");
		  return;
		}
		
//		Iterator<MemberDTO> iter = memList.iterator();
//		
//		while(iter.hasNext()) {
//			MemberDTO m = (MemberDTO)iter.next();
//			
//			
//		}		
		
		int no = 1;
    for(MemberDTO m : memList) {
      mp.printInfo(m,no);
      no++;
    }
  }//end of printMemberList
	

}
