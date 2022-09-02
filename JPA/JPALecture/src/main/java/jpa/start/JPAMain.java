package jpa.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPALECTURE");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();



        try{
            System.out.println("시작");

            Address address = new Address("city","street","10000");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAddress(address);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAddress(address);
            em.persist(member2);


            System.out.println("================");

            System.out.println("================");
           //지우면 데이터 insert안됨
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        System.out.println("종료");
        emf.close();
    }



}
