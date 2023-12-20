package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    //    @OneToMany(mappedBy = "team")
    // mappedBy (가짜 매핑)
    // 객체와 테이블간에 연관관계를 맺는 차이를 이해해야 한다!
    // 객체의 양방향 관계는 사실 양방향 관계가 아닌 서로 다른 다른 단방향 관계 2개 이다.

    // private List<Member> members = new ArrayList<>();

    // public void addMember(Member member) {
    //    member.setTeam(this);
    //    members.add(member);
    //    }
    @OneToMany
    @JoinColumn(name = "TEAM_ID") // 일대다 단방향은 Join컬럼 사용!!
    private List<Member> members = new ArrayList<>();

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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

}
