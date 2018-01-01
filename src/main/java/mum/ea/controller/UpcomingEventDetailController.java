package mum.ea.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.ea.config.GetCurrentUser;
import mum.ea.domain.Comment;
import mum.ea.domain.Event;
import mum.ea.domain.Facility;
import mum.ea.domain.FacilityType;
import mum.ea.domain.User;
import mum.ea.service.EventService;
import mum.ea.service.FacilityService;

@Controller
public class UpcomingEventDetailController {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	GetCurrentUser getCurrentUser;
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private EventService eventService;
	
	
	private List<Comment> getAllEventComment(Event event) {
		int id = event.getId();
	    TypedQuery query = em.createQuery("select c from Comment c left join c.event e where e.id = "+id, Comment.class);
	    return query.getResultList();
	}
	 
	@GetMapping("/eventDetail/{id}")
	public String index(@PathVariable int id, Model model) {
		Event event = eventService.getEvent(id);
		List<Comment> comments = getAllEventComment(event);
		model.addAttribute("event", event);
		model.addAttribute("comments", comments);
		return "upcomingEventDetail";
	}
}
