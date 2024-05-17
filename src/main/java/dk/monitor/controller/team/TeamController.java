package dk.monitor.controller.team;

import dk.monitor.dto.request.TeamRequest;
import dk.monitor.service.team.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team")
    public void saveTeam(TeamRequest request) {
        teamService.saveTeam(request);
    }

//    @GetMapping("/team")
//    public TeamResponse getTeam(@RequestBody TeamRequset requset) {
//
//        return new TeamResponse;
//

//    }

}
