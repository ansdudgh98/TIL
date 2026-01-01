package jpql;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;
import java.util.List;

class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        //code
        try {

            Member member1 = new Member();
            member1.setUsername("member");
            member1.setAge(1);
            em.persist(member1);


            for(int i =0 ;i<100;i++){
                Member member = new Member();
                member.setUsername("member"+i);
                member.setAge(i);
                em.persist(member);
            }

            em.flush();
            em.clear();

            System.out.println("===========");

            String query = "update Member m set m.age = 20";

            int resultCount = em.createQuery(query).
                    executeUpdate();

            System.out.println(resultCount);
            System.out.println("===========");

            em.find(Member.class,member1.getId());

            System.out.println("=================");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

