package com.codecool.hogwartshouses.runner;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.entity.Student;
import com.codecool.hogwartshouses.data.House;
import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.repository.StudentRepository;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator {

    private final RoomMemory roomMemory;
    private final StudentRepository studentRepository;

    @Autowired
    public DatabasePopulator(RoomMemory roomMemory, StudentRepository studentRepository) {
        this.roomMemory = roomMemory;
        this.studentRepository = studentRepository;
        initialize();
    }

    public void initialize() {
        Student Hermione = new Student(1, "Hermione Granger", Pet.CAT);
        Student Malfoy = new Student(2, "Draco Malfoy", Pet.OWL);
        Student Luna = new Student(3, "Luna Lovegood", Pet.NONE);
        studentRepository.save(Hermione);
        studentRepository.save(Malfoy);
        studentRepository.save(Luna);

        Room GryffindorRoom = new Room(1, House.GRYFFINDOR, Hermione);
        Room SlytherinRoom = new Room(2, House.SLYTHERIN, Malfoy);
        Room HufflepuffRoom = new Room(3, House.HUFFLEPUFF, Luna);
        Room RavenclawRoom = new Room(4, House.RAVENCLAW, null);
        roomMemory.add(GryffindorRoom);
        roomMemory.add(SlytherinRoom);
        roomMemory.add(HufflepuffRoom);
        roomMemory.add(RavenclawRoom);
    }
}
