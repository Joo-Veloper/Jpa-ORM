package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //jpa가 관리하는 객체!
@Table(name = "MBR") // 예를들어 테이블을 다른 이름을 맵핑하고 싶어 dba가 멤버라고 쓰면 안되요! 에를 들어 mbr이라고 쓰야하 해요 라고 하면 @Table(name = "MBR")이라고 쓰면 됨
//@Table(name = "USER") //멤버 이름이 다를때 : 데이터 베이스에 멤버가 아니라 유저 라고
                      // 되어있다면 @Table(name = "USER") 해주면 쿼리가 나갈때 user 테이블에 인서트 하고 나간다.!
public class Member {
    @Id //db에게 pk가 뭔지 알려 줘야 함!!
    private Long id;
//    @Column을 매핑해주면 됩니다. @Column(name = "username")
    private String name;
    private int age;
    public Member() {
    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
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
