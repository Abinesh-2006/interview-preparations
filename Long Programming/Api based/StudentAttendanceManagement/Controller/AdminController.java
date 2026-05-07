package org.example.studentattendance.Controller;

import org.example.studentattendance.Model.Student;
import org.example.studentattendance.Model.Teacher;
import org.example.studentattendance.Services.StudentServices;
import org.example.studentattendance.Services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    StudentServices studentServices;
    @GetMapping("/Allstudents")
    public List<Student> ShowAllStudents(){
        return studentServices.showAllStudents();
    }
    @Autowired
    TeacherServices teacherServices;
  @GetMapping("/Allteachers")
    public  List<Teacher> ShowAllTeachers(){
        return teacherServices.showAllTeachers();
  }

}
