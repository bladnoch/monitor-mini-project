package dk.monitor.domain.team;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Team {
    protected Team() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25)
    private String name;

    @Column(length = 20)
    private String manager;

    private Long memberCount;

    public Team(String name, String manager, long memberCount) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }
}