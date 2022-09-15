package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;

import java.util.Set;

public interface RoomDAO {
    Set<Room> getAll();
    void add(Room room);
    Room get(Long id);
    void delete(Long id);
    Room update(Long id, HouseType houseType);
}