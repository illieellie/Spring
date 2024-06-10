package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        // close 기능은 ApplicationContext 에서는 제공하지 않는다.
        // 보다 하위 기능인 ConfigurableApplicationContext 까지 내려가야함
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

    }
    @Configuration
    static class LifeCycleConfig{
        // 초기화, 종료 콜백 메서드 지정
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            // 객체 생성을 하고 set으로 url을 지정해줬기 때문에 connet 메소드에서는 url이 null
            return networkClient;
        }

    }
}
