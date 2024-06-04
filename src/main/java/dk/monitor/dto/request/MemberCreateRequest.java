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
    private final int vacation;

    public MemberCreateRequest(String name, String teamName, String role, LocalDate workStartDate, LocalDate birthday, int vacation) {
        this.name = name;
        this.teamName = teamName.toUpperCase(Locale.ROOT);
        this.role = role.toUpperCase(Locale.ROOT);
        this.workStartDate = workStartDate;
        this.birthday = birthday;

        //올해 입사한 member가 아니면 연차 15
        if (LocalDate.now().getYear() != workStartDate.getYear()) {
            this.vacation = 15;
        } else {
            // 연차 11
            this.vacation = 11;
        }

    }

}
