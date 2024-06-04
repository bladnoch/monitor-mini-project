package dk.monitor.domain.attendance;

import dk.monitor.domain.member.Member;
import dk.monitor.repository.member.MemberRepository;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.function.LongToDoubleFunction;

@Getter
@Entity
public class Attendance {

    protected Attendance() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 받은 id를 기반으로 생성



    private LocalDateTime workStarted; // 일 시작 시간
    private LocalDateTime workFinished; // 일 끝난 시
    private LocalDate date;

    private Long hours;


    public Attendance(Member member) {
        this.member = member;
        this.date = LocalDate.now();
        this.workStarted = LocalDateTime.now();
    }

    @JoinColumn(nullable = false)
    @ManyToOne
    Member member;
    // 업무 종료시 호출

    public void updateHour() {
        // 호출되는 시점으로 업무 종료
        this.workFinished = LocalDateTime.now();
        Duration duration = Duration.between(workStarted, workFinished);
        this.hours = duration.toMinutes();
    }


}
