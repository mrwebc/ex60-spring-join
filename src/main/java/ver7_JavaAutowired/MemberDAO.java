package ver7_JavaAutowired;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;


public class MemberDAO {
	
	private static int id = 0;
	
	private Map<String, MemberDTO> memMap
		= new HashMap<String, MemberDTO>();


	//해당 이메일로 등록된 정보 유무
	public MemberDTO selectedByEmail(String email) {
		return memMap.get(email);
	}

	//Map 저장소에 등록
	public void insert(MemberDTO memDto) {		
		memDto.setId(id++);
		memMap.put(memDto.getEmail(), memDto);
	}
	
	//회원목록
	public Collection<MemberDTO> getList() {
		
//		Set<String> set = memMap.keySet();
//		
//		Iterator<String> iter = set.iterator();
//		
//		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
//		
//		while(iter.hasNext()) {					
//			memList.add(memMap.get(iter.next()));		
//		}
//		
		return memMap.values();
		
//		return memList;
		
	}

	//암호 변경
	public void updatePwd(MemberDTO memDto) {
		memMap.put(memDto.getEmail(), memDto);
		
	}

}
