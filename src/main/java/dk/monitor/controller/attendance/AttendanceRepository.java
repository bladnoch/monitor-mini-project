package dk.monitor.controller.attendance;

import dk.monitor.domain.attendance.Attendance;
import dk.monitor.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByMemberIdAndWorkFinished(Long id, LocalDateTime finished);

    List<Attendance> findALLByMemberId(Long memberId);
}
