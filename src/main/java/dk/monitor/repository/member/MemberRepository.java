package dk.monitor.repository.member;

import dk.monitor.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();
}
