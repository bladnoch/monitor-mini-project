package dk.monitor.service.member;

import dk.monitor.domain.member.Member;
import dk.monitor.domain.team.Team;
import dk.monitor.dto.Response.MembersResponse;
import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.repository.member.MemberRepository;
import dk.monitor.repository.team.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void saveMember(MemberCreateRequest request) {
        // member 저장
        memberRepository.save(new Member(request.getName(),request.getTeamName(), request.getRole(), request.getBirthday(), request.getWorkStartDate()));

        long memberCount = 0; // oneTeam.getMemberCount()
        String role = null; // ontTeam.getRole();


        // Team 저장 / 업데이트
        // Team 저장
            // 새로운 Team 생성
            // 저장
        // Team 업데이트 : member의 팀이름이 team 에 있을경우
            // role 이 MANAGER인지 확인
            // memberCount++
            // 업데이트


        // 예외처리 : teamName 이 없을 경우
        System.out.println("print: request = " + request.getName()+" "+ request.getTeamName()+" "+ request.getRole()+" "+ request.getBirthday()+" "+ request.getWorkStartDate());
        // 저장할 member정보를 통해 team 정보를 가져온다
        Team oneTeam = teamRepository.findByName(request.getTeamName()); // input의 teamName 기준으로 Team 가져오기
        System.out.println("print: team name = "+oneTeam.getName());  // DB에 팀이 있을경우 정상적으로 Team을 불러옴
        // team이 없을 때 어떻게 출력되는지 확인해야함

        // 가져온 team 정보를 수정
        // memberCount 업데이트
        // local memberCount를 통해 저장하고 new Response를 만들 때 이용
        memberCount = oneTeam.getMemberCount() + 1;
        System.out.println("print: memberCount = " + memberCount + " " + (oneTeam.getMemberCount()+1));

        // role 업데이트
       if(request.getRole().equals("MANAGER")){
           // oneTeam에 이름 => request.getName() 추가
           role = oneTeam.getManager();
           System.out.println("print: role = " + role+ " "+ oneTeam.getManager());

       }

//        teamRepository.save(new Team(oneTeam.getName(), role, memberCount)); // 없을경우
//        teamRepository. // 있을경우 onteam.getName()을 통해 memberCount, role만 추가
    }

    /**
     * 모든 멤버 정보 body로 전달
     * @return member list
     */
    @Transactional(readOnly = true)
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



