package dk.monitor.dto.request;

import lombok.Getter;

import java.util.Locale;

@Getter
public class TeamCreateRequest {

    public TeamCreateRequest() {
        this.memberCount = 0L;
    }

    public TeamCreateRequest(String name) {
        this.name =name.toUpperCase(Locale.ROOT);
        this.manager = null;
        this.memberCount = 0L;
    }

    private Long id;

    private String name;

    private String manager;

    private Long memberCount;
}
