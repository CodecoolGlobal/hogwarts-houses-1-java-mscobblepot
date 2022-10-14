package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.logic.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/rooms")
public class RoomEndpoint {
    private final RoomService roomService;

    @Autowired
    public RoomEndpoint(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getRooms(Model model) {
        Set<Room> rooms = roomService.getRooms();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @PostMapping
    public String addRoom(@RequestBody Room room, Model model) {
        roomService.addRoom(room);
        return getRooms(model);
    }

    @GetMapping("/{id}")
    public String getRoom(@PathVariable("id") Long id, Model model) {
        Room room = roomService.getRoom(id);
        model.addAttribute("room", room);
        return "rooms";
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable("id") Long id, Model model) {
        roomService.deleteRoom(id);
        return getRooms(model);
    }

    @PutMapping("/{id}")
    public String updateRoom(@PathVariable("id") Long id, @RequestBody Room updatedRoom, Model model) {
        roomService.updateRoom(id, updatedRoom.getHouseType());
        return getRooms(model);
    }

    @GetMapping("/available")
    public String getAvailableRooms(Model model) {
        Set<Room> availableRooms = roomService.getAvailableRooms();
        model.addAttribute("rooms", availableRooms);
        return "rooms";
    }

    @GetMapping("/rat-owners")
    public String getRoomsForRatOwners(Model model) {
        Set<Room> roomsForRatOwners = roomService.getRoomsForRatOwners();
        model.addAttribute("rooms", roomsForRatOwners);
        return "rooms";
    }
}
