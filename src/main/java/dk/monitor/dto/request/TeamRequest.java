package dk.monitor.dto.request;

import lombok.Getter;

@Getter
public class TeamRequest {

    private Long id;

    private String name;

    private String manager;

    private Long memberCount;

    public TeamRequest(String name) {
        this.name = name;
        this.manager = null;
        this.memberCount = 0L;
    }
}
