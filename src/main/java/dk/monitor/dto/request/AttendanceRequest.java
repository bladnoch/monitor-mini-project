package dk.monitor.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AttendanceRequest {
    public AttendanceRequest(Long memberId) {
        this.memberId = memberId;
    }

    private Long memberId;
}
