package dk.monitor.service;

import dk.monitor.controller.attendance.AttendanceRepository;
import dk.monitor.domain.attendance.Attendance;
import dk.monitor.domain.member.Member;
import dk.monitor.dto.Response.MemberHoursResponse;
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

    // 일 생성, 일 시작 저장
    public void saveStart(AttendanceRequest request) {
        // id, start, finish, memberId, hour
//        Member currentMember = memberRepository.findByIdAndWorkFinished(request.getMemberId(), null).orElseThrow(IllegalArgumentException::new);
        if(attendanceRepository.findByMemberIdAndWorkFinished(request.getMemberId(), null).isPresent()){
            throw new IllegalArgumentException("현재 출근상태 입니다.");
        }


        // 예외처리 : 출근상태에선 출근 불가
        Member currentMember = memberRepository.findById(request.getMemberId()).orElseThrow(IllegalArgumentException::new);

        currentMember.saveInList(request.getMemberId());
    }

    // 일 끝 저장
    public void saveFinish(AttendanceRequest request) {
        Attendance attendance= attendanceRepository.findByMemberIdAndWorkFinished(request.getMemberId(), null)
                .orElseThrow(IllegalArgumentException::new);
        attendance.updateHour();
    }

    // 월 기준 멤버의 일한 날짜, 일별 시간 리턴
    public List<MemberHoursResponse> getWorkHours(Long memberId, String month) {

        List<Attendance> attendances  =attendanceRepository.findALLByMemberId(memberId);
        List<MemberHoursResponse> updatedAttendance = new ArrayList<>();

        for (Attendance attend : attendances) {
            if (attend.getDate().toString().substring(0,7).equals(month) && attend.getWorkFinished()!=null) {
                updatedAttendance.add(new MemberHoursResponse(attend.getDate(), attend.getHours()));
            }
        }
        return updatedAttendance;
    }

    // 전체 일한 시간 리턴
    public Long getSum(List<MemberHoursResponse> memberHours) {
        Long sum = 0L;
        for (MemberHoursResponse hour : memberHours){
            sum += hour.getWorkingMinutes();
        }
        return sum;
    }
}
