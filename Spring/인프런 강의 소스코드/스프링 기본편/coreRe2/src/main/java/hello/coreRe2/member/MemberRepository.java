package hello.coreRe2.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
