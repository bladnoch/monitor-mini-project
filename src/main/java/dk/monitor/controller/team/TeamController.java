package dk.monitor.controller.team;

import dk.monitor.dto.Response.TeamResponse;
import dk.monitor.dto.request.TeamCreateRequest;
import dk.monitor.service.team.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // 예외처리: 같은 이름의 팀이 있으면 저장되지 않아야 함
    @PostMapping("/team")
    public void saveTeam(TeamCreateRequest request) {
        teamService.saveTeam(request);
    }

    @GetMapping("/team")
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }

}
