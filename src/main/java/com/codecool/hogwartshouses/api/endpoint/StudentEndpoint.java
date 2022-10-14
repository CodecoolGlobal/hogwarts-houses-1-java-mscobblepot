package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.persistence.entity.Student;
import com.codecool.hogwartshouses.logic.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/students")
public class StudentEndpoint {
    private final StudentService studentService;

    @Autowired
    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        Set<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping
    public String addStudent(@RequestBody Student student, Model model) {
        studentService.addRoom(student);
        return getStudents(model);
    }
}
