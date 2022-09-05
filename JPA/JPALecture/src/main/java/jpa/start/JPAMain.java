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

            List<Member> resultList = em.createQuery(
                    "select m From Member m where m.username like '%kim%'", Member.class
            ).getResultList();

            for (Member member : resultList) {

            }


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
