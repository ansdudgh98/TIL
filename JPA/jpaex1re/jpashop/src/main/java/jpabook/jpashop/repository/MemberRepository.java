package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //Spring Bean으로 등록
@RequiredArgsConstructor
public class MemberRepository {

/*
    @PersistenceContext //일반적인 JPA는 Autowired를 통한 생성자 주입이 불가능하여 PersistenceContext를 사용하여야 되지만
    //Spring jpa는 Autowired로 생성이 기능함
    private EntityManager em;
*/
    private final EntityManager em;



    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }

}
