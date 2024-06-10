package hello.core.lifecycle;


public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connet : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnet() {
        System.out.println("close : " + url);
    }


    public void init(){
        // Bean 의존 관계 주입 후 호출
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }


    public void close(){
        // 소멸 시점에 호출
        System.out.println("NetworkClient.destroy");
        disconnet();
    }


}
