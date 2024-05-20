package dk.monitor.service.team;

import dk.monitor.dto.request.TeamCreateRequest;


public interface TeamService{

    void saveTeam(TeamCreateRequest request);

}
