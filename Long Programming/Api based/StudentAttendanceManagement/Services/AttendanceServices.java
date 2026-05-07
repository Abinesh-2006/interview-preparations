package org.example.studentattendance.Services;

import org.example.studentattendance.Model.Attendance;
import org.example.studentattendance.Repository.AttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServices {
    @Autowired
    AttendanceRepo attendanceRepo;
    public Attendance markAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }

    public Attendance getAttendanceById(int id) {
        return attendanceRepo.findById(id).orElseThrow(() -> new RuntimeException("Attendance not found"));
    }
}