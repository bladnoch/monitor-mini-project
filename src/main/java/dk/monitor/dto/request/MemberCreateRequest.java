package dk.monitor.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberCreateRequest {

    private String name;

    private boolean role;  // manager? or member?

    private LocalDate workStartDate;
    private LocalDate birthday;
    private String teamName;
    public MemberCreateRequest(String name, boolean role, LocalDate workStartDate, LocalDate birthday) {
        this.name = name;
        this.role = role;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
        this.teamName = "none";
    }


    public boolean getRole() {
        return role;
    }
}
