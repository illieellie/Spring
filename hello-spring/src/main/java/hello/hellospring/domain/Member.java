package hello.hellospring.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// javax 는 2019년도 이후부터 이름이 jakarta로 수정되었다고 함
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
// JPA가 관리하는 객체라는 애노테이션 추가
public class Member {
    // annotation을 활용하여 맵핑,
    // PK 맵핑, Identity : DB가 자동생성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Name") // db column name mapping
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
