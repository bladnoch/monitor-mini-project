package dk.monitor.service.member;

import dk.monitor.domain.member.Member;
import dk.monitor.domain.team.Team;
import dk.monitor.dto.Response.MembersResponse;
import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.exaptions.ManagerException;
import dk.monitor.repository.member.MemberRepository;
import dk.monitor.repository.team.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // member 새로 만들기
        memberRepository.save(new Member(request.getName(),request.getTeamName(), request.getRole(), request.getBirthday(), request.getWorkStartDate()));

        /*
         member table과 team table의 관개 생성
         member과 team의 관계
         (teamName -> name), (role -> manager), (memberCount)

         team 새로 만들기 / 업데이트
         member에 적힌 팀이 team table에 있는지 확인
         찾는 팀이 있을 경우 불러오기 없을경우 empty

         */
        Optional<Team> team = teamRepository.findByName(request.getTeamName()); // input의 teamName 기준으로 Team 가져오기

        // team 없음
        if(team.isEmpty()){
            // team 없음, manager 맞음
            if(request.getRole().equals("MANAGER")){
                // team 새로 만들기, (teamName, manager 추가 memberCount++)
                teamRepository.save(new Team(request.getTeamName(), request.getName(), 1L)); // name, role, memberCount
            }
            // team 업음, manager 아님
            else{
                // team 새로 만들기, (teamName 추가, memberCount++)
                teamRepository.save(new Team(request.getTeamName(), null, 1L));
            }
        }
        // team 있음
        else{
            // 팀 불러와 변수에 저장
            Team theteam = team.get();
            // team 있음, manager 맞음
            if(request.getRole().equals("MANAGER")){
                // team 있음, manager 맞음, team 에 manager 없음
                if (theteam.getManager()==null) {
                    // team 업데이트 (manager 추가, memberCount++)
                    theteam.updateManagerAndMemberCount(request.getName());
                }
                // team 있음, manager 맞음, manager 있음
                else {
                    // 예외처리 : manager 있을 경우 저장되지 않도록 한다.
                    throw new ManagerException("manager이 존재합니다.");
                }
            }
            // team 있음, manager 아님
            else{
                theteam.updateMemberCount();
            }
            teamRepository.save(theteam); // name, role, memberCount
        }
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



