package hellojpa;

import javax.persistence.*;

@Entity
//@MappedSuperclass
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    //TEAM
    @ManyToOne(fetch = FetchType.LAZY)// 지연로딩
//    @ManyToOne(fetch = FetchType.EAGER)// 즉시로딩 -> 멤버를 로딩을 할 때 팀까지 같이 조인해서 가지고 온다(실무 즉시 로딩 사용 x)
    @JoinColumn(name = "TEAM_ID")
//    @JoinColumn(name = "TEAM_ID",insertable = false, updatable = false) //insertable, updatable을 이용하면 읽기 전용이됩니다.
    private Team team;

    // LOCKER
//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

    // PRODUCT(N:N) N:N은 사용 안하는게 좋음!
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    //MEMBER PRODUCT (1:N)
//    @OneToMany(mappedBy ="member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    N : 1
//    @ManyToOne(fetch = FetchType.LAZY) //fetch 사용하면 쿼리가 분리 되어서 나갑니다.(지연 로딩 전략)
//    @ManyToOne // Mmeber와 Team을 보면 Member가 N이고 Team 1이기 때문에 Member 메서드에서 Team과 연관관계이기 때문에 ManyToOne 사용!
//    @JoinColumn(name = "TEAM_ID") // 이관계와 Join하는 컬럼이 무엇인지 적어줌!
//    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
//    LOCKER
//    public Locker getLocker() {
//        return locker;
//    }
//
//    public void setLocker(Locker locker) {
//        this.locker = locker;
//    }
//
//    public List<MemberProduct> getMemberProducts() {
//        return memberProducts;
//    }
//
//    public void setMemberProducts(List<MemberProduct> memberProducts) {
//        this.memberProducts = memberProducts;
//    }
}