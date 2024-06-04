package dk.monitor.service;

import dk.monitor.controller.attendance.AttendanceRepository;
import dk.monitor.domain.attendance.Attendance;
import dk.monitor.domain.member.Member;
import dk.monitor.dto.request.AttendanceRequest;
import dk.monitor.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final MemberRepository memberRepository;



    public void saveStart(AttendanceRequest request) {
        // id, start, finish, memberId, hour
        Member currentMember = memberRepository.findById(request.getMemberId()).orElseThrow(IllegalArgumentException::new);
        attendanceRepository.save(new Attendance(currentMember));

    }


    public void saveFinish(AttendanceRequest request) {
        Attendance attendance= attendanceRepository.findByMemberIdAndWorkFinished(request.getMemberId(), null);
        attendance.updateHour();

    }

    public List<Attendance> getWorkHours(Long id, String month) {
        // working on it
        return new ArrayList<>();
    }
}
