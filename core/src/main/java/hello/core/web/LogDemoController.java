package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    // 스프링 컨테이너가 뜨면서 의존관계 주입을 해야하는데 mylogger는 request scope이라 아직 고객 요청이 없어서 에러 => ObjectProvider 사용
    // 위 코드를 줄이기 위해 프록시 사용 @Scope(value="request",proxyMode = ScopedProxyMode.TARGET_CLASS)
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString(); // 고객이 요청한 url을 받을 수 있음
        //MyLogger myLogger = myLoggerProvider.getObject(); // 주입 시점에 주입 받을 수 있음
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
