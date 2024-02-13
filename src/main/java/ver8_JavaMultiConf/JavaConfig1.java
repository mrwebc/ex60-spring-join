package ver8_JavaMultiConf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//해당 클래스는 스프링 설정으로 사용된다는 것을 의미
@Configuration
public class JavaConfig1 {

  //리턴한 객체를 Bean 객체로 사용되도록 설정
  @Bean
  public MemberDAO memberDao() {
    return new MemberDAO();
  }
  
  @Bean
  public MemberPrinter mp() {
    return new MemberPrinter();
  }
  
   
}
