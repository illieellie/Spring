package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + bean1);
        System.out.println("prototypeBean2 = " + bean2);
        // 서로 다른 빈이 출력되고 init 메서드만 호출, destory 호출 (x)
        ac.close();

    }

    //@Component -> 쓰지 않아도 위에서 직접 넣어주면 컴포넌트 대상 자체로 인식해서 등록.
    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("prototypeBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("prototypeBean.destory");
        }


    }

}
