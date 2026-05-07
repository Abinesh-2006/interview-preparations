package org.example.studentattendance.Repository;

import org.example.studentattendance.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance,Integer> {
}
