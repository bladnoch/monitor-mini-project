package dk.monitor.controller.team;

import dk.monitor.dto.Response.TeamResponse;
import dk.monitor.dto.request.TeamCreateRequest;
import dk.monitor.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeamController {

    private final TeamService teamService;

    // 팀 저장
    @PostMapping("/team")
    public void saveTeam(@RequestBody TeamCreateRequest request) {
        teamService.saveTeam(request);
    }

    // 모든 팀 맴버 출력
    @GetMapping("/team")
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }

}
