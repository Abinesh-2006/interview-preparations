package org.example.studentattendance.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        LocalDate date;
        String status;
        @ManyToOne
                @JoinColumn(name = "student_id")
        Student student;
        @ManyToOne
                @JoinColumn(name = "teacher_id")
        Teacher teacher;
}
