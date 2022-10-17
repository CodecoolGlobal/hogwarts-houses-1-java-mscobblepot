package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.data.House;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomDAO roomDAO;

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

    public void updateRoom(Long id, House houseType) {
        roomDAO.update(id, houseType);
    }
    public Set<Room> getAvailableRooms() {
       return roomDAO.getAllAvailable();
    }

    public Set<Room> getRoomsForRatOwners() {
        return roomDAO.getAllForRatOwners();
    }
}
