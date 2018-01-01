package mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.ea.domain.Room;
import mum.ea.service.BuildingService;
import mum.ea.service.FacilityService;
import mum.ea.service.RoomService;

@Controller
@RequestMapping(value = "/admin")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private BuildingService buildingService;

	@GetMapping("/rooms")
	public String getBuildings(Model m) {
		m.addAttribute("rooms", roomService.getAllRooms());
		return "roomList";
	}

	@GetMapping("/buildings/{buildingId}/rooms")
	public String getBuildingRooms(@PathVariable int buildingId, Model m) {
		m.addAttribute("rooms", roomService.findByBuilding(buildingId));
		return "roomList";
	}
	

	@GetMapping("/rooms/{id}")
	public String getRoom(@PathVariable int id, Model m) {
		m.addAttribute("buildings", buildingService.getAllBuildings());
		m.addAttribute("room", roomService.getRoom(id));
		return "roomDetail";
	}

	@GetMapping("/addRoom")
	public String addRoomView(Model m) {
		m.addAttribute("buildings", buildingService.getAllBuildings());
		m.addAttribute("room", new Room());
		return "roomDetail";
	}

	@PostMapping("/rooms")
	public String addRoom(Room b) {
		roomService.addRoom(b);
		return "redirect:/admin/rooms";
	}

	@PostMapping("/rooms/{id}")
	public String updateRoom(Room b) {
		roomService.updateRoom(b);
		return "redirect:/admin/rooms";
	}

	@PostMapping("/rooms/delete/{id}")
	public String deleteRoom(Room b) {
		roomService.deleteRoom(b.getId());
		return "redirect:/admin/rooms";
	}

}
