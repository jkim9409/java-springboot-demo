package myfirst.javaspringbootdemo.service;

import myfirst.javaspringbootdemo.domain.Member;
import myfirst.javaspringbootdemo.repository.MemberRepository;
import myfirst.javaspringbootdemo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    sign-up
    public long join(Member member) {

        //Rule: No user with the same name
        validateDuplicateMember(member);


        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("User already exist");
                });
    }

    // list of all the members
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
