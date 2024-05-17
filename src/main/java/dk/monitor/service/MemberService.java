package dk.monitor.service;

import dk.monitor.dto.request.MemberCreateRequest;
import dk.monitor.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface MemberService {

    void saveMember(MemberCreateRequest request);
}
