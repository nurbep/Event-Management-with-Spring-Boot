package mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mum.ea.domain.Event;
import mum.ea.repository.EventRepository;
import mum.ea.service.CategoryService;
import mum.ea.service.EventService;
import mum.ea.service.FacilityService;

@Controller
public class MainController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("event", new Event());
		model.addAttribute("events", eventRepository.findAllByOrderByIdDesc());
		return "upcomingEventList";
	}
	
	@PostMapping("/")
	public String getAllEventss( Event e, Model m) {
		m.addAttribute("events", eventService.findAll(e.getName()));
		//commentService.findAll(c.getDescription());
		
		System.out.println("mmmmmmmmmmmmmmmmmmmm "+eventService.findAll(e.getName()));
		return "upcomingEventList";
	}
	@GetMapping("/e")
	public String getAllEventsByName(Model m) {
		//m.addAttribute("events",eventService.findAll());
		m.addAttribute("event", new Event());
		return "eventSearch";
	}
}
