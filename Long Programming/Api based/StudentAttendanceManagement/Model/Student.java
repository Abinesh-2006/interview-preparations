package org.example.studentattendance.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String StudentName;
    private String StudentDept;
    @OneToMany(mappedBy = "student")
    List<Attendance> attendance;
    @ManyToOne
    @JoinColumn(name = "Teacher_Id")
    Teacher teacher;
    Student(String StudentName , String StudentDept){
        this.StudentName = StudentName;
        this.StudentDept = StudentDept;
    }
}
