package jpql;

import javax.persistence.*;
import java.util.List;

class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        //code
        try {
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);


            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

            String query = "select t From Team t join fetch t.members";

            List<Team> result = em.createQuery(query,Team.class)
                    .getResultList();
            for (Team team : result) {
                System.out.println("team = " + team.getName() + "|" + team.getMembers().size());
            }


//            for(int i=0; i<100;i++) {
//                Member member = new Member();
//                member.setUsername("member"+i);
//                member.setAge(i);
//
//                Team team = new Team();
//                team.setName("teamA");
//                em.persist(team);
//
//                member.setTeam(team);
//
//                em.persist(member);
//            }
//
//            String query = "select m from Member m inner join m.team t";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();


            tx.commit();

//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username","member1");
//            //값이 여러개 일때
//            List<Member> resultList = query.getResultList();
//          결과가 하나일 때 무조건 오류가 나온다.
//            Member singleResult = query.getSingleResult();
//
//            System.out.println("singleResult = " + singleResult);

            //영속성 컨텍스트에 모든 값이 저장됨 -> Member엔티티에 한정해서
//
//            List<Member> result = em.createQuery("select m from Member m",Member.class).
//                    getResultList();
//            //영속성 컨텍스트에 모든 값이 저장됨 -> Team엔티티에 한정해서  join도 됨
//            List<Team> teamresult = em.createQuery("select m.team from Member m",Team.class)
//                    .getResultList();
//
//            //임베디드 타입
//            List<Member> orderresult = em.createQuery("select o.address from Order o",Member.class).
//                    getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            Query query2 = em.createQuery("select m.username, m.age from Member m");
//
//

//        em.createQuery("select m from Member m order by m.age desc ",Member.class)
//                        .setFirstResult(1)
//                        .setMaxResults(100)
//                        .getResultList();
//
//            System.out.println("resultList.size() = " + resultList.size());
//
//            for (Member member1 : resultList) {
//                System.out.println("member1.toString() = " + member1.toString());
//            }

            



        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

