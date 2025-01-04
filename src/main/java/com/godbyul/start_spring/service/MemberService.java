package com.godbyul.start_spring.service;

import com.godbyul.start_spring.domain.Member;
import com.godbyul.start_spring.repository.MemberRepository;
import com.godbyul.start_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private MemberRepository memberRepository;
    MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public long join(Member member) {
        validateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(long id) {
        return memberRepository.findById(id);
    }
}
