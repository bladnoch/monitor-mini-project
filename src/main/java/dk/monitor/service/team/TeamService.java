package dk.monitor.service.team;

import dk.monitor.dto.Response.TeamResponse;
import dk.monitor.dto.request.TeamCreateRequest;

import java.util.List;


public interface TeamService{

    void saveTeam(TeamCreateRequest request);

    List<TeamResponse> getTeams();

}
