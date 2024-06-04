package dk.monitor.repository.member;

import dk.monitor.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();



}
