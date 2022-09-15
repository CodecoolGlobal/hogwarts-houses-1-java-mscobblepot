package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {

    private final RoomMemory roomMemory;

    @Autowired
    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
        initialize();
    }

    public void initialize() {
        Room GryffindorRoom = new Room(1, HouseType.GRYFFINDOR);
        Room SlytherinRoom = new Room(2, HouseType.SLYTHERIN);
        Room HufflepuffRoom = new Room(3, HouseType.HUFFLEPUFF);
        Room RavenclawRoom = new Room(4, HouseType.RAVENCLAW);
        roomMemory.add(GryffindorRoom);
        roomMemory.add(SlytherinRoom);
        roomMemory.add(HufflepuffRoom);
        roomMemory.add(RavenclawRoom);
    }
}
