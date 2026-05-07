package org.example.studentattendance.Services;

import org.example.studentattendance.Model.Teacher;
import org.example.studentattendance.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServices {
    @Autowired
    TeacherRepo teacherrepo;

    public List<Teacher> showAllTeachers() {
        return teacherrepo.findAll();
    }

    public String addTeacher(Teacher teacher) {
                teacherrepo.save(teacher);
        return "teacher added successfully";
    }

    public Teacher showDetails(int id) {
        return teacherrepo.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }
    public String deleteById(int id) {
        if(!teacherrepo.existsById(id)){
            throw new RuntimeException("Teacher Not Found ");
        }
        teacherrepo.deleteById(id);
        return "teacher deleted successfully";
    }
}
