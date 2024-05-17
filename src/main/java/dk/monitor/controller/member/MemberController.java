package dk.monitor.controller.member;

import dk.monitor.dto.Response.MembersResponse;
import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.service.member.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/member")
    public List<MembersResponse> getMembers() {
        return memberService.getMembers();
    }

//    @GetMapping("/team")
//    public TeamResponse getTeam(@RequestBody TeamRequset requset) {
//
//        return new TeamResponse;

//    }

//
//    @PostMapping("/team")
//


}
