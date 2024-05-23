package dk.monitor.service;

import dk.monitor.controller.attendance.AttendanceRepository;
import dk.monitor.domain.member.Member;
import dk.monitor.dto.request.AttendanceRequest;
import dk.monitor.repository.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AttendanceService {
    private AttendanceRepository attendanceRepository;
    private MemberRepository memberRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, MemberRepository memberRepository) {
        this.attendanceRepository = attendanceRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void saveStart(AttendanceRequest request) {
        // id, start, finish, memberId, sum



        // 1. Attendance의 출근에 값이 있는지 확인
        // 2. Attendance의 출근에 값이 없으면 workStart 추가
        // 3. 있으면 workFinished에 추가
            // 4. sum을 불러오고 퇴근-출근 값을 sum에 추가
        // 4.save로 저장
    }

    @Transactional
    public void saveFinish(AttendanceRequest request) {

    }
}
