package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentCreator {
    private final StudentMemory studentMemory;

    @Autowired
    public StudentCreator(StudentMemory studentMemory) {
        this.studentMemory = studentMemory;
        initialize();
    }

    public void initialize() {
        Student Hermione = new Student(1, "Hermione Granger");
        Student Malfoy = new Student(2, "Draco Malfoy");
        studentMemory.add(Hermione);
        studentMemory.add(Malfoy);
    }
}
