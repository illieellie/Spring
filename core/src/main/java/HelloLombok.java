import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// * getter, setter를 자동으로 생성해줌
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args){

        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("abcd");

        String name = helloLombok.getName();
        System.out.println("name : " + name );
    }
}
