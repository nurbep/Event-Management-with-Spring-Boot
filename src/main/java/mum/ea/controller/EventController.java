package mum.ea.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.ea.domain.Event;
import mum.ea.domain.Facility;
import mum.ea.service.CategoryService;
import mum.ea.service.EventService;
import mum.ea.service.FacilityService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FacilityService facilityService;

	@GetMapping("/events")
	public String getEvents(Model m) {
		m.addAttribute("events", eventService.getAllEvents());
		return "eventList";
	}

	@GetMapping("/events/{id}")
	public String getEvent(@PathVariable int id, Model m) {
		m.addAttribute("categories", categoryService.getAllCategories());
		m.addAttribute("facilities", facilityService.getAllFacilities());
		m.addAttribute("event", eventService.getEvent(id));
		return "eventDetail";
	}

	@GetMapping("/addEvent")
	public String addEventView(Model m) {
		m.addAttribute("categories", categoryService.getAllCategories());
		m.addAttribute("facilities", facilityService.getAllFacilities());
		m.addAttribute("event", new Event());
		return "eventDetail";
	}

	@PostMapping("/events")
	public String addEvent(@Valid Event e, BindingResult result) {
		if (result.hasErrors()) {
			return "addEvent";
		} else {
			eventService.addEvent(e);
			return "redirect:/events";
		}
	}

	@PostMapping("/events/{id}")
	public String updateEvent(@PathVariable Integer id, Model m, @ModelAttribute("event") @Validated Event e,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		
		m.addAttribute("categories", categoryService.getAllCategories());
		m.addAttribute("facilities", facilityService.getAllFacilities());
		
		if (result.hasErrors()) {
			return "eventDetail";
		} else if (!eventService.findAllByFacilityAndDateBetween(e).isEmpty()) {
			m.addAttribute("errorMsg", "Sorry !! Place is already booked for the given time");
			return "eventDetail";
		}else {
			eventService.updateEvent(e);
			return "redirect:/events";
		}
	}

	@PostMapping("/events/delete/{id}")
	public String deleteEvent(Event e) {
		eventService.deleteEvent(e.getId());
		return "redirect:/events";
	}

	@ExceptionHandler(value = NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("fullPageMessage");
		return mv;
	}
}