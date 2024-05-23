package dk.monitor.controller.attendance;


import dk.monitor.dto.request.AttendanceRequest;
import dk.monitor.service.AttendanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {

    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/attendance/start")
    public void savestart(@RequestBody AttendanceRequest request) {
        attendanceService.saveStart(request);
    }

    @PostMapping("attendance/finish")
    public void saveFinish(@RequestBody AttendanceRequest request) {
        attendanceService.saveFinish(request);
    }
}
