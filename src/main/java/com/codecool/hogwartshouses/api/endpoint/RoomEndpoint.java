package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.logic.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomEndpoint {
    private final RoomService roomService;

    @GetMapping
    public String getRooms(Model model) {
        List<Room> rooms = roomService.getRooms();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @PostMapping
    public String addRoom(@RequestBody Room room, Model model) {
        roomService.saveRoom(room);
        return getRooms(model);
    }

    @GetMapping("/{id}")
    public String getRoom(@PathVariable("id") Long id, Model model) {
        roomService.getRoom(id).ifPresent(room -> model.addAttribute("room", room));
        return "rooms";
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable("id") Long id, Model model) {
        roomService.deleteRoom(id);
        return getRooms(model);
    }

    @PutMapping
    public String updateRoom(@RequestBody Room updatedRoom, Model model) {
        roomService.saveRoom(updatedRoom);
        return getRooms(model);
    }

    @GetMapping("/available")
    public String getAvailableRooms(Model model) {
        List<Room> availableRooms = roomService.getAvailableRooms();
        model.addAttribute("rooms", availableRooms);
        return "rooms";
    }

    @GetMapping("/rat-owners")
    public String getRoomsForRatOwners(Model model) {
        List<Room> roomsForRatOwners = roomService.getRoomsForRatOwners();
        model.addAttribute("rooms", roomsForRatOwners);
        return "rooms";
    }
}
