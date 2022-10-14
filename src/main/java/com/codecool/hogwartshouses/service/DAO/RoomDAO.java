package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.data.House;

import java.util.Set;

public interface RoomDAO {
    Set<Room> getAll();
    void add(Room room);
    Room get(Long id);
    void delete(Long id);
    void update(Long id, House houseType);
    Set<Room> getAllAvailable();
    Set<Room> getAllForRatOwners();
}