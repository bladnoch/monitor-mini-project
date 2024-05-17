package dk.monitor.service;

import dk.monitor.domain.Member;
import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.repository.MemberRepository;

import java.time.LocalDate;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void saveMember(MemberCreateRequest request) {
        memberRepository.save(new Member(request.getName(),request.getTeamName(), request.getRole(), request.getBirthday(), request.getWorkStartDate()));
    }

}
