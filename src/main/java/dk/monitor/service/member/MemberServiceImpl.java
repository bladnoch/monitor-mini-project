package dk.monitor.service.member;

import dk.monitor.domain.member.Member;
import dk.monitor.dto.Response.MembersResponse;
import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.repository.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void saveMember(MemberCreateRequest request) {
        System.out.println("request = " + request.getName()+" "+ request.getTeamName()+" "+ request.getRole()+" "+ request.getBirthday()+" "+ request.getWorkStartDate());
        memberRepository.save(new Member(request.getName(),request.getTeamName(), request.getRole(), request.getBirthday(), request.getWorkStartDate()));
    }

    public List<MembersResponse> getMembers() {
        List<MembersResponse> result = new ArrayList<>();
        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            result.add(
                    new MembersResponse(
                            member.getName(), member.getTeamName(), member.getRole(), member.getBirthday(), member.getWorkStartDate()));
        }

        return result;
    }

}
