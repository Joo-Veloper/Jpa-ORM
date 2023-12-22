package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}


// 즉시 로딩/ 지연로딩 //fetch

//public class JpaMain {
//
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try {
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("Member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("Member2");
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//
//            em.flush();
//            em.clear();
//
//            // 즉시 로딩/ 지연로딩
////            Member m = em.find(Member.class, member2.getId());
////
////            System.out.println("m = " + m.getTeam().getClass());
////
////            System.out.println("=============");
////            System.out.println("teamName = " + m.getTeam().getName());
////            System.out.println("=============");
//
//            //fetch join
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();
//
//
//
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//        emf.close();
//    }
//}




//public class JpaMain {
//
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try {
//
//            // 1
////            team.setName("TeamA");
////            em.persist(team);
////            Member member = new Member();
////            member.setUsername("member1");
////            em.persist(member);
////            team.addMember(member);
////            em.flush();
////            em.clear();
////            Team findTeam = em.find(Team.class, team.getId());
////            List<Member> members = findTeam.getMembers();
////            System.out.println("==============");
////            System.out.println("members = " + findTeam);
////            System.out.println("==============");
//            // 2
////            Member member = new Member();
////            member.setUsername("member1");
////            em.persist(member);
////            tx.commit();
////            // 저장
////            Team team  = new Team();
////            team.setName("teamA");
////            team.getMembers().add(member);
////            em.persist(team);
//
//            // 3
////            Movie movie = new Movie();
////            movie.setDirector("aaaa");
////            movie.setActor("bbbb");
////            movie.setName("바람과 함께 사라지다.");
////            movie.setPrice(100000);
////            em.persist(movie);
////            Movie findMovie = em.find(Movie.class, movie.getId());
////            System.out.println("findMovie = " + findMovie);
////            Item item = em.find(Item.class, movie.getId());
////            System.out.println("item = " + item);
//
//            //4
////            Member member = new Member();
////            member.setUsername("user1");
////            member.setCreatedBy("kim");
////            member.setCreatedDate(LocalDateTime.now());
////            em.persist(member);
////            em.flush();
////            em.clear();
//
//            // 5
//            Member member1 = new Member();
//            member1.setUsername("Member1");
//            em.persist(member1);
//
////            Member member2 = new Member();
////            member2.setUsername("Member2");
////            em.persist(member2);
//
//            em.flush();
//            em.clear();
//// 5 - 5
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); //proxy
//            Hibernate.initialize(refMember); //강제 초기화
//// 5 - 4
////            Member refMember = em.getReference(Member.class, member1.getId());
////            System.out.println("refMember = " + refMember.getClass()); //proxy
////            refMember.getUsername();
////            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//
////            em.detach(refMember); // detach를 하면 영속성 컨텍스트 더이상 관리 안해라고 됨 ->해당 변경사항이 더는 추적되지 않습니다.
////            em.clear(); // 영속성 컨텍스트를 끈건 아니지만 깨끗하게 지우고 시작
//
//            refMember.getUsername();
//
//            System.out.println("refMember = " + refMember.getUsername());
//// 5 - 3
////            Member refMember = em.getReference(Member.class, member1.getId());
////            System.out.println("refMember = " + refMember.getClass());
////            refMember.getUsername();
////
////            Member findMember = em.find(Member.class, member1.getId());
////            System.out.println("findMember = "  + findMember.getClass());
////            System.out.println("refMember == findMember:" + (refMember == findMember));
//
//// 5 - 2
////            Member refMember = em.find(Member.class, member1.getId());
////            System.out.println("refMember = " + refMember.getClass());
////            em.getReference(Member.class, member1.getId());
////
////            Member findMember = em.getReference(Member.class, member1.getId());
////            System.out.println("findMember = "  + findMember.getClass());
////            System.out.println("a == a:" + (refMember == findMember)); // jpa 에서는 a와 a를 하면 항상 true
//// 5 - 1
////            Member m2 = em.getReference(Member.class, member2.getId());
////            logic(refMember, m2);
////            Member findMember = em.find(Member.class, member.getId());
////            Member findMember = em.getReference(Member.class, member1.getId());
////            System.out.println("before findMember = " + findMember.getClass()); // 하이버네이트가 만든 가짜 프록시
////            System.out.println("findMember.id = " + findMember.getId());
////            System.out.println("findMember.username = " + findMember.getUsername());
////            System.out.println("after findMember = " + findMember.getClass()); // 하이버네이트가 만든 가짜 프록시
//
//
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//        emf.close();
//    }
//
////    private static void logic(Member m1, Member m2) {
////        //비지니스 로직에서 타입 비교할때 프록시로 넘어올지, 실제로 넘어올지 모르기 때문에 그래서 절때 타입비교 == XXXX
//////        System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass())); // 이방식 xx
////        System.out.println("m1 == m2 : " + (m1 instanceof Member)); //-> 이방식 사용
////        System.out.println("m1 == m2 : " + (m2 instanceof Member)); //-> 이방식 사용
////    }
//
//}