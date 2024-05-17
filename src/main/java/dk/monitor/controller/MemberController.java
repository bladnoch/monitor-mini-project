package dk.monitor.controller;

import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public void saveMember(@RequestBody MemberCreateRequest request) {
        memberService.saveMember(request);
    }

//    @GetMapping("/team")
//    public TeamResponse getTeam(@RequestBody TeamRequset requset) {
//
//        return new TeamResponse;

//    }
//    @GetMapping("/member")
//
//    @PostMapping("/team")
//


}
