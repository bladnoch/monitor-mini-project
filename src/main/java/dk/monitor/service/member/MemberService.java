package dk.monitor.service.member;

import dk.monitor.dto.Response.MembersResponse;
import dk.monitor.dto.request.MemberCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    void saveMember(MemberCreateRequest request);

    List<MembersResponse> getMembers();
}
