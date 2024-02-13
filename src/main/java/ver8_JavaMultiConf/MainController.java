package ver8_JavaMultiConf;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exception.DuplicateMemberException;
import exception.MemberNotFoundException;
import exception.PasswordNotMatchingException;

public class MainController {
	
	//도움말
	public static void help() {
		System.out.println("");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 변경암호");
		System.out.println("list");
    System.out.println("info 이메일");
		System.out.println("exit - 프로그램 종료");
		System.out.println("ver - 프로그램 버전");
		System.out.println("help - 도움말");
		System.out.println("");
	}	
	

//	private static Factory factory = new Factory();

	public static void main(String[] args) {
	  
	  //GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx3.xml");
	  
	  //스프링 컨테이너 생성c
	  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig1.class,JavaConfig2.class);
	  
    help();

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("명령어를 입력하세요:");
			String userInput = sc.nextLine();

			
			//사용자가 입력한 명령어에서 데이터 분리
			String[] userInputs = userInput.split(" ");
			
			if(userInput.startsWith("new")){

				//전달받은 데이터의 개수확인
				if(userInputs.length < 5) {
					System.out.println("누락된 정보가 있으니 다시 입력해주세요.");
					help();
					continue;
				}
				
				//전달받은 데이터를 MemberReigistDTO 객체에 담는다.
				requestDTO req = new requestDTO(userInputs[1], 
												userInputs[2], 
												userInputs[3], 
												userInputs[4]);
				
				//유효성검증(암호일치)
				if(!req.comparePwd()) {
					System.out.println("두개의 암호가 서로 일치하지 않습니다.");					
					continue;
				}

				//MemberRegisterSerivce memRegSrv = factory.getMemRegSrv();
				MemberRegisterSerivce memRegSrv = ctx.getBean("memRegSrv", MemberRegisterSerivce.class);
				
				try {
				  memRegSrv.regist(req);				  
				}catch(DuplicateMemberException e) {
				  System.out.println(e.getMessage());
				}
				
				
			}else if(userInput.startsWith("change")) {
				
				//전달받은 데이터의 개수확인
				if(userInputs.length < 4) {
					System.out.println("누락된 정보가 있으니 다시 입력해주세요.");
					help();
					continue;
				}
				
				String email = userInputs[1];
				String oldPwd = userInputs[2];
				String newPwd = userInputs[3];
				
				//MemberPwdChangeService memPwdChgSrv = factory.getMemPwdChangeSrv();
				MemberPwdChangeService memPwdChgSrv = ctx.getBean("memPwdChgSrv",MemberPwdChangeService.class);
				  
				try {
				  memPwdChgSrv.changePwd(email, oldPwd, newPwd);
		      System.out.println("암호변경 완료~!");
				}catch(MemberNotFoundException e) {
				  System.out.println(e.getMessage());
				}catch(PasswordNotMatchingException e) {
          System.out.println(e.getMessage());				  
				}
				//입력한 이메일에 해당하는 정보 유무 확인
//				MemberDTO memDto = memPwdChgSrv.existMember(email);
//				if(memDto==null) {
//					System.out.println("입력한 이메일과 일치하는 회원정보가 없습니다.");
//					continue;
//				}
				
				
        //암호를 변경
//        memDto.changePwd(oldPwd, newPwd);
        
        //Map 저장소에 업데이트
//        memPwdChgSrv.chgPwd(memDto);
				
			
			}else if(userInput.compareToIgnoreCase("list")==0) {
//					MemberListService memListSrv = factory.getMemListSrv();
					MemberListService memListSrv = ctx.getBean("memListSrv",MemberListService.class);
					memListSrv.printMemberList();
				
			}else if(userInput.startsWith("info")){
	       
        //전달받은 데이터의 개수확인
        if(userInputs.length != 2) {
          System.out.println("입력한 내용이 형식에 맞지 않습니다. 다시 입력해주세요.");
          help();
          continue;
        }       
        
			  MemberInfoService memInfoSrv = ctx.getBean("memInfoSrv",MemberInfoService.class);
        String email = userInputs[1];
        memInfoSrv.printMember(email);
        
      }else if(userInput.compareToIgnoreCase("exit")==0) {
				System.out.println("종료합니다.");
				break;
				
			}else if(userInput.compareToIgnoreCase("ver")==0){
        VersionPrinter vp = ctx.getBean("vp",VersionPrinter.class);
        vp.printVersion();   
        
      }else if(userInput.compareToIgnoreCase("help")==0){
			  System.out.println("아래 명령어 사용법을 확인하세요");
			  help();
			  
			}else {
				System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
				help();
				
			}//end of if
			
		}//end of while
		
		sc.close();
	}//end of main

}//end of MainController
