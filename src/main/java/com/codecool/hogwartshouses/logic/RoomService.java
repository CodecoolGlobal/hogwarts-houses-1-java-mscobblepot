package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    public Optional<Room> getRoom(Long id) {
        return roomRepository.findById(id);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByStudentIsNull();
    }

    public List<Room> getRoomsForRatOwners() {
        return roomRepository.findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn(List.of(Pet.CAT, Pet.OWL));
    }
}
