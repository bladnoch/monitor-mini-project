package dk.monitor.dto.Response;

import lombok.Getter;

import java.util.Locale;

@Getter
public class TeamCreateResponse {
    private final String name;
    private final String role;
    private final long memberCount;

    public TeamCreateResponse(String name, String role, long memberCount) {
        this.name = name;
        this.role = role;
        this.memberCount = memberCount;
    }
}
