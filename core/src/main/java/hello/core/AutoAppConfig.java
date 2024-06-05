package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( // -> 자동으로 스프링 빈에 등록
        excludeFilters =@ComponentScan.Filter(classes = Configuration.class)
)
public class AutoAppConfig {
    // type annotation은 default


}
