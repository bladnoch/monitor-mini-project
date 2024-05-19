package dk.monitor.service.member;

import dk.monitor.domain.member.Member;
import dk.monitor.domain.team.Team;
import dk.monitor.dto.Response.MembersResponse;
import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.repository.member.MemberRepository;
import dk.monitor.repository.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberServiceImpl(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    /**
     * member 개인정보 저장
     * @param request (name, teamName, role, birthday,workStartDate)
     */
    public void saveMember(MemberCreateRequest request) {
        // teamName이 없는 경우 예외처리
        System.out.println("print: request = " + request.getName()+" "+ request.getTeamName()+" "+ request.getRole()+" "+ request.getBirthday()+" "+ request.getWorkStartDate());
        // 저장할 member정보를 통해 team 정보를 가져온다
        Team oneTeam = teamRepository.findByName(request.getTeamName());
        System.out.println("print: team name = "+oneTeam.getName());  // DB에 팀이 있을경우 정상적으로 Team을 불러옴
        // team이 없을 때 어떻게 출력되는지 확인해야함
        // 가져온 team 정보를 수정
//       if(request.getRole().equals("MANAGER")){
//           // oneTeam에 이름=>request.getName() 추가
//       }
        memberRepository.save(new Member(request.getName(),request.getTeamName(), request.getRole(), request.getBirthday(), request.getWorkStartDate()));
    }

    /**
     * 모든 멤버 정보 body로 전달
     * @return member list
     */
    public List<MembersResponse> getMembers() {
        List<MembersResponse> result = new ArrayList<>();
        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            result.add(new MembersResponse(
                    member.getName(),
                    member.getTeamName(),
                    member.getRole(),
                    member.getBirthday(),
                    member.getWorkStartDate()));
        }

        return result;
    }


}



