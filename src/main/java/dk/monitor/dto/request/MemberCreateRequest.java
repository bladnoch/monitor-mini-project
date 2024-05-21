package dk.monitor.dto.request;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Locale;

@Getter
public class MemberCreateRequest {

    private final String name;
    private final String role;  // manager? or member?
    private final LocalDate workStartDate;
    private final LocalDate birthday;
    private final String teamName;

    public MemberCreateRequest(String name, String teamName, String role, LocalDate workStartDate, LocalDate birthday) {
        this.name = name;
        this.teamName = teamName.toUpperCase(Locale.ROOT);
        this.role = role.toUpperCase(Locale.ROOT);
        this.workStartDate = workStartDate;
        this.birthday = birthday;

    }

}
