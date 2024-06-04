package dk.monitor.domain.team;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Team {

    public Team(String name, String manager, long memberCount) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25)
    private String name;

    @Column(length = 20)
    private String manager;
    private Long memberCount;

    //== ==//

    // 맴버 추가될 때 호출
    // 메니저, 멤버 ++
    public void updateManagerAndMemberCount(String managerName) {
        this.manager = managerName;
        this.memberCount++;
    }

    // 멤버 추가될 때 호출
    // 맴버 ++
    public void updateMemberCount(){
        this.memberCount++;
    }
}