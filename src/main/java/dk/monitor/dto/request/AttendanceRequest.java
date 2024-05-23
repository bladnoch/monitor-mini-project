package dk.monitor.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AttendanceRequest {

    private long memberId;

    public AttendanceRequest(long memberId) {
        this.memberId = memberId;
    }

}
