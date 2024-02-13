package ver9_ComponentScan;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import exception.DuplicateMemberException;

@Service
public class MemberRegisterSerivce {
	
	@Autowired private MemberDAO dao;
	
	public MemberRegisterSerivce(MemberDAO dao) {
		this.dao = dao;
	}

	public void regist(requestDTO req) {

		
		 //기존에 등록된 정보와 중복여부
		 if(dao.selectedByEmail(req.getEmail())!=null) {
			 //System.out.println("이미 등록된 이메일 입니다.");
			 throw new DuplicateMemberException("이미 등록된 이메일 입니다.");
		 }
		 
		 MemberDTO memDto = new MemberDTO(
				 req.getEmail(),
				 req.getName(),
				 req.getPwd(),
				 new Date()
				 );
		 
		 
		 //DAO 메소드를 통해서 저장소에 등록
		 dao.insert(memDto);//데이터 등록
		 System.out.println("등록했습니다.");

	}
}
