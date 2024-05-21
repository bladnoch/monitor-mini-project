package dk.monitor.service.team;

import dk.monitor.domain.team.Team;
import dk.monitor.dto.Response.TeamResponse;
import dk.monitor.dto.request.TeamCreateRequest;
import dk.monitor.exaptions.TeamException;
import dk.monitor.repository.team.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(TeamCreateRequest request) {
        //예외처리 : 새로 만드는 팀 이름이 이미 있는경우 throw exception

        // team 없음
        if (teamRepository.findByName(request.getName()).isEmpty()){
            // team 새로 만들기
            teamRepository.save(new Team(request.getName(),request.getManager(),request.getMemberCount()));
        }
        // team 있음
        else{
            // exception 날리기
            throw new TeamException(request.getName() + "은 이미 존재하는 팀 입니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<TeamResponse> getTeams(){
        List<TeamResponse> response= new ArrayList<>();
        List<Team> teams = teamRepository.findAll();

        for (Team team : teams) {
            // name, manager, memberCount
            response.add(new TeamResponse(team.getName(), team.getManager(), team.getMemberCount()));
        }

        return response;
    }
}
