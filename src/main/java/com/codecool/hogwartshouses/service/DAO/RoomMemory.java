package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class RoomMemory implements RoomDAO {

    private final Set<Room> rooms;

    public RoomMemory(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }

    @Override
    public void add(Room room) {
        rooms.add(room);
    }

    @Override
    public Room get(Long id) {
        return rooms.stream()
                .filter(room -> id.equals(room.getId()))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        rooms.removeIf(room -> room.getId() == id);
    }

    @Override
    public Room update(Long id, HouseType houseType) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                room.setHouseType(houseType);
            }
        }
        return new Room(id, houseType);
    }
}
