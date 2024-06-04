package dk.monitor.controller.attendance;


import dk.monitor.dto.request.AttendanceRequest;
import dk.monitor.service.AttendanceService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/attendance/start")
    public void saveStart(@RequestBody AttendanceRequest request) {
        attendanceService.saveStart(request);
    }

    @PostMapping("/attendance/finish")
    public void saveFinish(@RequestBody AttendanceRequest request) {
        attendanceService.saveFinish(request);
    }

    @GetMapping("/attendance")
    public ResponseEntity<?> getWorkHours(@RequestParam Long id, @RequestParam String month) {

        List<Member>  attendanceService.getWorkHours(id, month);

        return ResponseEntity.ok().body(
                Map.of("detail", )
        );
    }


}
`