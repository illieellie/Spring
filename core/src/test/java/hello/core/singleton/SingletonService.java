package hello.core.singleton;

public class SingletonService {
    // 1. static 영역에 객체를 딱 1개만 생성
    private static final SingletonService instance = new SingletonService(); // 자기 자신의 인스턴스 생성

    // 2. private으로 생성 막음
    private SingletonService(){

    }

    // 3. 항상 같은 인스턴스를 반환
    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }






}
