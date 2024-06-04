package dk.monitor.controller.attendance;

import dk.monitor.domain.attendance.Attendance;
import dk.monitor.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Attendance findByMemberIdAndWorkFinished(Long id, LocalDateTime finished);
}
