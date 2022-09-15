package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
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
        Student Hermione = new Student(1, "Hermione Granger");
        Student Malfoy = new Student(2, "Draco Malfoy");
        studentMemory.add(Hermione);
        studentMemory.add(Malfoy);

        Room GryffindorRoom = new Room(1, HouseType.GRYFFINDOR, Hermione);
        Room SlytherinRoom = new Room(2, HouseType.SLYTHERIN, Malfoy);
        Room HufflepuffRoom = new Room(3, HouseType.HUFFLEPUFF, null);
        Room RavenclawRoom = new Room(4, HouseType.RAVENCLAW, null);
        roomMemory.add(GryffindorRoom);
        roomMemory.add(SlytherinRoom);
        roomMemory.add(HufflepuffRoom);
        roomMemory.add(RavenclawRoom);
    }
}
