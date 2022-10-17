package com.codecool.hogwartshouses.runner;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.entity.Student;
import com.codecool.hogwartshouses.data.House;
import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.repository.RoomRepository;
import com.codecool.hogwartshouses.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator {

    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public DatabasePopulator(RoomRepository roomRepository, StudentRepository studentRepository) {
        this.roomRepository = roomRepository;
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
        roomRepository.save(GryffindorRoom);
        roomRepository.save(SlytherinRoom);
        roomRepository.save(HufflepuffRoom);
        roomRepository.save(RavenclawRoom);
    }
}
