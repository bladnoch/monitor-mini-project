package dk.monitor.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class Member {
    protected Member() {
    }

    public Member(String name, String teamName, boolean role, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 25)
    private String teamName;

    private boolean role;  // is manager or member t/f

    private LocalDate birthday;

    private LocalDate workStartDate;

}
