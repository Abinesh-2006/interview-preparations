package org.example.studentattendance.Controller;

import org.example.studentattendance.Model.Student;
import org.example.studentattendance.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
@Autowired
    StudentServices studentServices;
   @PostMapping("/AddStudent")
   public String addStudent(@RequestBody Student student) {
       return studentServices.addstudent(student);
   }
   @GetMapping("/showdetails{id}")
   Student showDetails(@PathVariable int id){
       return studentServices.showDetails(id);
   }
   @DeleteMapping("/delete{id}")
    public String deleteStudentById(@RequestBody int id){
       return studentServices.deleteStudentById(id);
   }
}
