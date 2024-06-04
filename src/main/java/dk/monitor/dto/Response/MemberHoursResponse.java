package dk.monitor.dto.Response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberHoursResponse {
    private LocalDate date;
    private Long workingMinutes;

    public MemberHoursResponse(LocalDate date, Long workingMinutes) {
        this.date = date;
        this.workingMinutes = workingMinutes;
    }
}
