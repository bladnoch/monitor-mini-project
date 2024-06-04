package dk.monitor.repository.member;

import dk.monitor.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();

//    Optional<Member> findByIdAndWorkFinished(Long memberId, LocalDateTime time);

}
