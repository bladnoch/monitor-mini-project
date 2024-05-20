package dk.monitor.dto.Response;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Locale;

@Getter
public class MembersResponse {
    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public MembersResponse(String name, String teamName, String role, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.teamName = teamName.toUpperCase(Locale.ROOT);
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }



}
