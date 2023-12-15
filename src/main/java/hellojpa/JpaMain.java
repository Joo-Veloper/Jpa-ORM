package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // 예를 들어 고객이 들어와서 행위를 하고 나가 이런걸 할 때 고객이 어떤 상품을 장바구니에 담아라던가 이런걸 할때마다
        // DB 커넥션을 얻어서 쿼리를 날리고 종료되는 그런 한 일관적인 단위를 할 때마다 이 엔티티 메니저라는 애를 꼭 만들어주어야함!!
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // 영속
            System.out.println("===BEFORE===");
            em.persist(member); // 메니저 안에 있는 영속성 컨텍스트라는 데를 통해서 이 멤버가 관리가 된다! (DB저장 되진 않음)
//            em.detach(member); // 영속성 컨텍스트에서 다시 지움

            System.out.println("===AFTER===");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
// 주의
// 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
// 엔티티 매니저는 쓰레드간에 공유하면 안됨!! 사용하고 버려야함
// JPA의 모든 데이터 변경은 트랜잭션 안에서 실행



//JPA 어플리케이션 개발
//public static void main(String[] args) {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//    EntityManager em = emf.createEntityManager(); // 예를 들어 고객이 들어와서 행위를 하고 나가 이런걸 할 때 고객이 어떤 상품을 장바구니에 담아라던가 이런걸 할때마다
//    // DB 커넥션을 얻어서 쿼리를 날리고 종료되는 그런 한 일관적인 단위를 할 때마다 이 엔티티 메니저라는 애를 꼭 만들어주어야함!!
//    EntityTransaction tx = em.getTransaction();
//    tx.begin();
//    try {
//            Member findMember = em.find(Member.class, 1L);
        // JPQL(엔티티 객체) 대상으로 쿼리 -> 장점 방언(oracle, mysql, h2 등 )으로 바꾸거나해도 이 코드를 이 jpql자체 변경 안해도 됨!!!
        // SQL(데이터베이스 테이블) 대상으로 쿼리
        // JPA 사용하면 엔티티 객체를 중심으로 개발하게 된다.
        // 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색한다.
        // 모든 DB를 객체로 변환하여 검색 불가능!
        // 애플리케이션에 필요한 데이터만 DB에 불러오면 결국 검색 조건이 포함된 SQL 날려야함!
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5) // 5번부터 8개 가져와
//                    .setMaxResults(8)
//                    .getResultList(); // JPA는 테이블 대상으로 절때 코드 짜지 않는다.!
//            for(Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }