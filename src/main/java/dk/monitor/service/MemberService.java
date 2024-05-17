package dk.monitor.service;

import dk.monitor.dto.Response.MembersResponse;
import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface MemberService {

    void saveMember(MemberCreateRequest request);

    List<MembersResponse> getMembers();
}
