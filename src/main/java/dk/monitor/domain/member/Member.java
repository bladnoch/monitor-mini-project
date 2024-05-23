package dk.monitor.domain.member;

import dk.monitor.domain.ManagerStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Locale;

@Getter
@Entity
public class Member {
    protected Member() {
    }

    public Member(String name, String teamName, String role, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20,name = "name")
    private String name;

    @Column(length = 25,name = "teamName")
    private String teamName;

    @Column(length = 25, name = "role")
    private String role;  // is manager or member

    // enum을 이용한 manager 여부
//    @Enumerated(EnumType.STRING)
//    private ManagerStatus role;


    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name= "workStartDate")
    private LocalDate workStartDate;

}
