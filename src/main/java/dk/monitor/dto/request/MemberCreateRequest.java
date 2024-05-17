package dk.monitor.dto.request;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Locale;

@Getter
public class MemberCreateRequest {

    private String name;
    private String role;  // manager? or member?
    private LocalDate workStartDate;
    private LocalDate birthday;
    private String teamName;

    public MemberCreateRequest(String name, String role, LocalDate workStartDate, LocalDate birthday) {
        this.name = name;
        this.role = role;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
        this.teamName = "none";
    }

}
