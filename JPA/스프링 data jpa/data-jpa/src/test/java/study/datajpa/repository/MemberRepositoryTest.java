package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.enitity.Member;
import study.datajpa.enitity.Team;
import study.datajpa.repository.dto.MemberDto;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired TeamRepository teamRepository;
    @Autowired EntityManager em;
    @Test
    public void basicCRUD() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();

        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        List<Member> all = memberRepository.findAll(); assertThat(all.size()).isEqualTo(2);

        long count = memberRepository.count(); assertThat(count).isEqualTo(2);

//        long deletedCount = memberRepository.count();
//
//        assertThat(deletedCount).isEqualTo(0);
    }
    @Test
    public void testMember(){
        System.out.println("memberRepository = " + memberRepository);
        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);

        Optional<Member> byId = memberRepository.findById(savedMember.getId());
        Member findMember = byId.get();
        assertThat(findMember.getId()).isEqualTo(savedMember.getId());
    }


    @Test
    public void findByUsernameAndGreaterThan(){
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("AAA", 15);

        assertThat(result.get(0).getUsername()).isEqualTo("AAA");
        assertThat(result.get(0).getAge()).isEqualTo(20);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void testNamedQuery(){
        Member m1 = new Member("AAA",10);
        Member m2 = new Member("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByUsername("AAA");
        Member findMember = result.get(0);
        assertThat(findMember).isEqualTo(m1);
    }

    @Test
    public void testQuery(){
        Member m1 = new Member("AAA",10);
        Member m2 = new Member("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findUser("AAA", 10);
        assertThat(result.get(0)).isEqualTo(m1);
    }

    @Test
    public void findUsernameList(){
        Member m1 = new Member("AAA",10);
        Member m2 = new Member("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<String> usernameList = memberRepository.findUsernameList();
        for (String s : usernameList) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void findMemberDto(){

        Team team = new Team("teamA");
        teamRepository.save(team);
        Member m1 = new Member("AAA",10);
        m1.setTeam(team);
        memberRepository.save(m1);

        List<MemberDto> findMemberDto = memberRepository.findMemberDto();
        for (MemberDto memberDto : findMemberDto) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findByNames(){

        Member m1 = new Member("AAA",10);
        Member m2 = new Member("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));
        for (Member member : result) {
            System.out.println("member = " + member);
        }

    }


    @Test
    public void returnType(){
        Member m1 = new Member("AAA",10);
        Member m2 = new Member("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        Optional<Member> findMember = memberRepository.findOptionalByUsername("AAA");


    }

    @Test
    public void Paging(){
        memberRepository.save(new Member("member1",10));
        memberRepository.save(new Member("member2",10));
        memberRepository.save(new Member("member3",10));
        memberRepository.save(new Member("member4",10));
        memberRepository.save(new Member("member5",10));

        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));
        int age = 10;

        //when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);

        Page<MemberDto> toMap = page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));


        //then
        List<Member> content = page.getContent();

        for (Member member : content) {
            System.out.println("member = " + member);
        }

        assertThat(content.size()).isEqualTo(3);
//        assertThat(page.getTotalElements()).isEqualTo(5);
        assertThat(page.getNumber()).isEqualTo(0);
    //  assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.isFirst()).isTrue();
        assertThat(page.hasNext()).isTrue();
    }

    @Test
    public void bulkUpdate(){
        memberRepository.save(new Member("member1",10));
        memberRepository.save(new Member("member2",19));
        memberRepository.save(new Member("member3",20));
        memberRepository.save(new Member("member4",21));
        memberRepository.save(new Member("member5",20));
        memberRepository.save(new Member("member6",40));

        int resultCount = memberRepository.bulkAgePlus(20);



        List<Member> result = memberRepository.findByUsername("member5");

        Member member5 = result.get(0);
        System.out.println("member5 = "+member5);

        assertThat(resultCount).isEqualTo(4);
    }

    @Test
    public void findMemberLazy(){
        //given
        //member1 -> teamA
        //member2 -> teamB

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamB);
        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

        List<Member> members = memberRepository.findMemberFetchJoin();

        for (Member member : members) {
            System.out.println("member= " + member);
            System.out.println("member = " + member.getTeam().getName());
        }
    }

    @Test
    public void queryHint(){
        //given
        Member member1 = memberRepository.save(new Member("member1", 10));
        em.flush();
        em.clear();

        //when
        Member findMember = memberRepository.findReadOnlyByUsername("member1");
        findMember.setUsername("member2");

        em.flush();
    }

    @Test
    public void lock(){
        //given
        Member member1 = memberRepository.save(new Member("member1", 10));
        em.flush();
        em.clear();

        //when
        List<Member> result = memberRepository.findLockByUsername("member1");
    }

    @Test
    public void callCustom() throws Exception{
        //given
        List<Member> result = memberRepository.findMemberCustom();
        //when

        //then

    }

    @Test
    public void queryByExample(){
        Team teamA = new Team("teamA");
        em.persist(teamA);

        Member m1 = new Member("m1",0,teamA);
        Member m2 = new Member("m2",0,teamA);

        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();

        //when
        //Probe
        Member member = new Member("m1");
        Team team = new Team("teamA");
        member.setTeam(team);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("age");

        Example<Member> example = Example.of(member);
        List<Member> result = memberRepository.findAll(example);
    }

    @Test
    public void projections(){
        Team teamA = new Team("teamA");
        em.persist(teamA);

        Member m1 = new Member("m1",0,teamA);
        Member m2 = new Member("m2",0,teamA);

        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();

        //when
//        List<UsernameOnly> result = memberRepository.findProjectionsByUsername("m1");
//        List<UsernameOnlyDto> result = memberRepository.findProjectionsByUsername("m1");
        List<NestedClosedProjection> result = memberRepository.findProjectionsByUsername("m1");
//        for (UsernameOnly usernameOnly : result) {
//            System.out.println("usernameOnly = " + usernameOnly);
//        }
//
//        for (UsernameOnlyDto usernameOnlyDto : result) {
//            System.out.println("usernameOnlyDto = " + usernameOnlyDto);
//        }

        for (NestedClosedProjection nestedClosedProjection : result) {
            System.out.println("nestedClosedProjection = " + nestedClosedProjection);
        }
    }

    @Test
    public void nativeQuery() throws Exception{
        //given
        Team teamA = new Team("teamA");
        em.persist(teamA);

        Member m1 = new Member("m1",0,teamA);
        Member m2 = new Member("m2",0,teamA);

        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();

        //when
//        Member result = memberRepository.findBytNativeQuery("m1");
        Page<MemberProjection> result = memberRepository.findByNativeProjection(PageRequest.of(1,10));
        List<MemberProjection> content = result.getContent();

        for (MemberProjection memberProjection : content) {
            System.out.println("memberProjection.getUsername() = " + memberProjection.getUsername());
            System.out.println("memberProjection.getTeamName() = " + memberProjection.getTeamName());
        }

        //then

    }

}
