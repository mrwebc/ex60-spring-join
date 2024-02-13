package ver9_ComponentScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//해당 클래스는 스프링 설정으로 사용된다는 것을 의미
@Configuration
@ComponentScan(basePackages = {"ver9_ComponentScan"})
public class JavaConfig {

  
  @Bean
  public VersionPrinter vp() {
    VersionPrinter vp = new VersionPrinter();
    vp.setMajorVersion(4);
    vp.setMinorVersion(3);
    return vp;
  }
   
}
