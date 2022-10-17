package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.persistence.entity.Student;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDAO studentDAO;

    public Set<Student> getStudents(){
        return studentDAO.getAll();
    }

    public void addRoom(Student student) {
        studentDAO.add(student);
    }
}
