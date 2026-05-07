package org.example.studentattendance.Controller;

import org.example.studentattendance.Model.Attendance;
import org.example.studentattendance.Services.AttendanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceServices  attendanceServices;
    @PostMapping("/mark")
    public String markAttendance(@RequestBody Attendance attendance) {
        attendanceServices.markAttendance(attendance);
        return "Attendance marked successfully";
    }
    @GetMapping
    public List<Attendance> getAttendance() {
        return attendanceServices.getAllAttendance();
    }
    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable int id) {
        return attendanceServices.getAttendanceById(id);
    }

}
