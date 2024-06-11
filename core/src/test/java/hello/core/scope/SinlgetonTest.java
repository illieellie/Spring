package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SinlgetonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);

        System.out.println("singletonBean1 = " + bean1);
        System.out.println("singletonBean2 = " + bean2);
        // 동일한 빈이 출력되고 init, destroy 메서드 모두 호출
        ac.close();

    }

    //@Component -> 쓰지 않아도 위에서 직접 넣어주면 컴포넌트 대상 자체로 인식해서 등록.
    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destory");
        }


    }

}
