package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.persistence.entity.Student;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Set<Student> getStudents(){
        return studentDAO.getAll();
    }

    public void addRoom(Student student) {
        studentDAO.add(student);
    }
}
