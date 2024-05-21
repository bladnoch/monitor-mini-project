package dk.monitor.dto.Response;

import lombok.Getter;

import java.util.Locale;

@Getter
public class TeamResponse {

    private String name;

    private String manager;

    private Long memberCount;

    public TeamResponse(String name, String manager, Long memberCount) {
        this.name =name.toUpperCase(Locale.ROOT);
        this.manager = manager;
        this.memberCount = memberCount;
    }
}
