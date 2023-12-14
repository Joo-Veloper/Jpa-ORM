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
//            Member findMember = em.find(Member.class, 1L);
            // JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList(); // JPA는 테이블 대상으로 절때 코드 짜지 않는다.!
            for(Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

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
// 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유!!
// 엔티티 매니저는 쓰레드간에 공유하면 안됨!!*사용하고 버려야함
// JPA의 모든 데이터 변경은 트랜잭션 안에서 실행 !!