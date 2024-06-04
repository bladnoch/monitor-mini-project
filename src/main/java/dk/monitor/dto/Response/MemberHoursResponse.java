package dk.monitor.dto.Response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberHoursResponse {
    private LocalDate date;
    private Long workingMinutes;
    private boolean usingDayOff;

    public MemberHoursResponse(LocalDate date, Long workingMinutes, boolean usingDayOff) {
        this.date = date;
        this.workingMinutes = workingMinutes;
        this.usingDayOff = usingDayOff;
    }
}
