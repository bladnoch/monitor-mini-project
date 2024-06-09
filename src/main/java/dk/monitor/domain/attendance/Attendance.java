package dk.monitor.domain.attendance;

import dk.monitor.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attendance {

    public Attendance(Member member) {
        this.member = member;
        this.date = LocalDate.now();
        this.workStarted = LocalDateTime.now();
        this.usingDayOff = false;
    }

    @JoinColumn(nullable = false)
    @ManyToOne
    Member member;

    // 변수
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 받은 id를 기반으로 생성
    private LocalDateTime workStarted; // 일 시작 시간
    private LocalDateTime workFinished; // 일 끝난 시
    private LocalDate date;
    private Long hours;
    private boolean usingDayOff;

    // 퇴근
    public void updateHour() {
        // 호출되는 시점으로 업무 종료
        this.workFinished = LocalDateTime.now();
        Duration duration = Duration.between(workStarted, workFinished);
        this.hours = duration.toMinutes();
    }

}
