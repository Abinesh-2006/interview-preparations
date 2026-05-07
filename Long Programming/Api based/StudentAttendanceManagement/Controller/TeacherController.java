package org.example.studentattendance.Controller;

import org.example.studentattendance.Model.Teacher;
import org.example.studentattendance.Repository.TeacherRepo;
import org.example.studentattendance.Services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherServices teacherServices;
    @PostMapping("/addteacher")
    public String addTeacher(@RequestBody Teacher teacher) {
        return teacherServices.addTeacher(teacher);
    }
    @GetMapping("/showdetails{id}")
    public Teacher ShowTeachers(@PathVariable int id){
          return teacherServices.showDetails(id);
    }
    @DeleteMapping("/delete{id}")
    public String deleteTeacherById(@RequestBody int id){
        return teacherServices.deleteById(id);
    }
}
