package dk.monitor.domain.attendance;

import jakarta.persistence.*;
import lombok.Getter;

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
    private Long id; // 받은 id를 기반으로 생성


    private LocalDateTime workStarted; // 일 시작 시간
    private LocalDateTime workFinished; // 일 끝난 시

    private LocalDateTime date;

    private Long sum;


    public Attendance(Long id, LocalDateTime date) {
        this.id = id;
        this.date = date;
        this.workStarted = date;
        this.workFinished = date;
    }

    // 업무 종료시 호출
    public void updateWorkFinished() {
        // 호출되는 시점으로 업무 종료
        this.workFinished = LocalDateTime.now();
    }
}
