package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomService {
    private final RoomDAO roomDAO;

    @Autowired
    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Set<Room> getRooms(){
        return roomDAO.getAll();
    }

    public void addRoom(Room room) {
        roomDAO.add(room);
    }

    public Room getRoom(Long id) {
        return roomDAO.get(id);
    }

    public void deleteRoom(Long id) {
        roomDAO.delete(id);
    }

    public Room updateRoom(Long id, HouseType houseType) {
        return roomDAO.update(id, houseType);
    }
}
