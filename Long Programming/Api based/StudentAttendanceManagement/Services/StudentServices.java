package org.example.studentattendance.Services;

import org.example.studentattendance.Model.Student;
import org.example.studentattendance.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    StudentRepo studentrepo;
    public List<Student> showAllStudents() {
        return studentrepo.findAll();
    }

    public Student showDetails(int id) {
        return studentrepo.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
    }
    public String addstudent(Student student) {
        studentrepo.save(student);
        return "Added student successfully";
    }
    public String deleteStudentById(int id){
        if(!studentrepo.existsById(id)){
            throw new RuntimeException("Student Not Found");
        }
        studentrepo.deleteById(id);
        return "Deleted student successfully";
    }
}
