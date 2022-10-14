package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.persistence.entity.Student;

import java.util.Set;

public interface StudentDAO {
    Set<Student> getAll();
    void add(Student student);
}
