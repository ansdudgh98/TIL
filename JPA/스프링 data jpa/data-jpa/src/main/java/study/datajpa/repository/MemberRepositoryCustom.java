package study.datajpa.repository;

import study.datajpa.enitity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
