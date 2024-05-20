package dk.monitor.service.team;

import dk.monitor.domain.team.Team;
import dk.monitor.dto.request.TeamCreateRequest;
import dk.monitor.repository.team.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;


    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeam(TeamCreateRequest request) {
        teamRepository.save(new Team(request.getName(),request.getManager(),request.getMemberCount()));
    }


}
