package dk.monitor.domain.attendance;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.function.LongToDoubleFunction;

@Getter
@Entity
public class Attendance {

    protected Attendance() {
    }

    @Id
    private Long id;


    private LocalDate date; // 일 한 날짜 저장
    private LocalTime workStarted; // 일 시작 시간
    private LocalTime workFinished; // 일 끝난 시


    private Long sum;

    public Attendance(Long sum) {
        this.date = LocalDate.now();
        this.sum = sum;
    }

}
