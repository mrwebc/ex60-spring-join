package ver6_JavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//해당 클래스는 스프링 설정으로 사용된다는 것을 의미
@Configuration
public class JavaConfig {

  //리턴한 객체를 Bean 객체로 사용되도록 설정
  @Bean
  public MemberDAO memberDao() {
    return new MemberDAO();
  }
  
  @Bean
  public MemberPrinter mp() {
    return new MemberPrinter();
  }
  
  @Bean
  public MemberRegisterSerivce memRegSrv() {
    return new MemberRegisterSerivce(memberDao());
  }
  
  @Bean
  public MemberPwdChangeService memPwdChgSrv() {
    return new MemberPwdChangeService(memberDao());
  }
  
  @Bean
  public MemberListService memListSrv() {
    MemberListService memListSrv = new MemberListService(memberDao());
    memListSrv.setMp(mp());
    return memListSrv;
  }
  
  
  @Bean 
  public MemberInfoService memInfoSrv() {
    MemberInfoService memInfoSrv = new MemberInfoService(memberDao());
    memInfoSrv.setMp(mp());
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
