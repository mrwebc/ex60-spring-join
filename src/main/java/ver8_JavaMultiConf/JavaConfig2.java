package ver8_JavaMultiConf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//해당 클래스는 스프링 설정으로 사용된다는 것을 의미
@Configuration
public class JavaConfig2 {

  //리턴한 객체를 Bean 객체로 사용되도록 설정
  @Bean
  public MemberRegisterSerivce memRegSrv() {
    return new MemberRegisterSerivce();
  }
  
  @Bean
  public MemberPwdChangeService memPwdChgSrv() {
    return new MemberPwdChangeService();
  }
  
  //자바설정으로 @Autowired를 사용할 경우 <context:annotation-config />처럼 별도의 설정을 할 필요가 없다.
  //단, 자바설정을 사용할 경우 생성자를 통한 @Autowired는 적용되지 않고, 필드나 메서드에 대해서만 동작한다.
  @Bean
  public MemberListService memListSrv() {
    //MemberListService memListSrv = new MemberListService(memberDao());
    MemberListService memListSrv = new MemberListService();
    //memListSrv.setMp(mp());
    return memListSrv;
  }
  
  
  @Bean 
  public MemberInfoService memInfoSrv() {
    //MemberInfoService memInfoSrv = new MemberInfoService(memberDao());
    MemberInfoService memInfoSrv = new MemberInfoService();
    //memInfoSrv.setMp(mp());
    return memInfoSrv;
  }
  
  @Bean
  public VersionPrinter vp() {
    VersionPrinter vp = new VersionPrinter();
    vp.setMajorVersion(4);
    vp.setMinorVersion(3);
    return vp;
  }
   
}
