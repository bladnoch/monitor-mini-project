package dk.monitor.dto.Response;

import lombok.Getter;

@Getter
public class TeamCreateResponse {
    private final String Name;
    private final String role;
    private final long memberCount;

    public TeamCreateResponse(String name, String role, long memberCount) {
        Name = name;
        this.role = role;
        this.memberCount = memberCount;
    }
}
