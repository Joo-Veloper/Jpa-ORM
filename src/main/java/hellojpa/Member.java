package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "USER") //멤버 이름이 다를때 : 데이터 베이스에 멤버가 아니라 유저 라고
                      // 되어있다면 @Table(name = "USER") 해주면 쿼리가 나갈때 user 테이블에 인서트 하고 나간다.!
public class Member {
    @Id //db에게 pk가 뭔지 알려 줘야 함!!
    private Long id;
//    @Column을 매핑해주면 됩니다. @Column(name = "username")
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
