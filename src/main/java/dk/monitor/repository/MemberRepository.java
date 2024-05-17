package dk.monitor.repository;

import dk.monitor.domain.Member;
import dk.monitor.dto.Response.MembersResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();
}
