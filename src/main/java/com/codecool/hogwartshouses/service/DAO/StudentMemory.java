package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.persistence.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class StudentMemory implements StudentDAO {

    private final Set<Student> students;

    public StudentMemory(Set<Student> students) {
        this.students = students;
    }

    @Override
    public Set<Student> getAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }
}
