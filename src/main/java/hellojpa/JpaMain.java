package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // 예를 들어 고객이 들어와서 행위를 하고 나가 이런걸 할 때 고객이 어떤 상품을 장바구니에 담아라던가 이런걸 할때마다
        // DB 커넥션을 얻어서 쿼리를 날리고 종료되는 그런 한 일관적인 단위를 할 때마다 이 엔티티 메니저라는 애를 꼭 만들어주어야함!!
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member findMember = em.find(Member.class, 1L);

            findMember.setName("HelloJPA");
            ;
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
