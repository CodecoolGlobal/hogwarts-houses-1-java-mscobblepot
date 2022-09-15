package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {

    private final RoomMemory roomMemory;
    private final StudentMemory studentMemory;

    @Autowired
    public RoomCreator(RoomMemory roomMemory, StudentMemory studentMemory) {
        this.roomMemory = roomMemory;
        this.studentMemory = studentMemory;
        initialize();
    }

    public void initialize() {
        Student Hermione = new Student(1, "Hermione Granger", PetType.CAT);
        Student Malfoy = new Student(2, "Draco Malfoy", PetType.OWL);
        Student Luna = new Student(3, "Luna Lovegood", PetType.NONE);
        studentMemory.add(Hermione);
        studentMemory.add(Malfoy);
        studentMemory.add(Luna);

        Room GryffindorRoom = new Room(1, HouseType.GRYFFINDOR, Hermione);
        Room SlytherinRoom = new Room(2, HouseType.SLYTHERIN, Malfoy);
        Room HufflepuffRoom = new Room(3, HouseType.HUFFLEPUFF, Luna);
        Room RavenclawRoom = new Room(4, HouseType.RAVENCLAW, null);
        roomMemory.add(GryffindorRoom);
        roomMemory.add(SlytherinRoom);
        roomMemory.add(HufflepuffRoom);
        roomMemory.add(RavenclawRoom);
    }
}
