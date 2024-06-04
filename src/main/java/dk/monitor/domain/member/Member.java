package dk.monitor.domain.member;

import dk.monitor.domain.ManagerStatus;
import dk.monitor.domain.attendance.Attendance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
@Entity
@NoArgsConstructor
public class Member {

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


    // cascade : 유저가 저장/삭제될 때 uerLoanHistories도 같이 삭제
    // orphanRemoval : 관계가 끝어지면 관계가 사라진 객체도 같이 삭제
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> allAttendance = new ArrayList<>();


    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name= "workStartDate")
    private LocalDate workStartDate;

}
