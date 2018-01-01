package mum.ea.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.EventGroup;
import mum.ea.domain.User;
import mum.ea.service.CategoryService;
import mum.ea.service.EventGroupService;
import mum.ea.service.UserServiceImpl;

@Controller
public class EventGroupController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	private EventGroupService eventGroupService;

	@GetMapping("/eventGroups")
	public String getComments(Model m) {
		m.addAttribute("eventGroups", eventGroupService.getAllGroups());
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		System.out.println( eventGroupService.getAllGroups());
		return "eventGroupList";
	}

	@GetMapping("/eventGroups/{id}")
	public String getComment(@PathVariable int id, Model m) {
		
		m.addAttribute("eventGroup", eventGroupService.getGroup(id));
		return "eventGroupDetail";
	}
	
	@GetMapping("/addEventGroup")
	public String addEventGroupView(Model m) {
		m.addAttribute("categoryList",categoryService.getAllCategories());
		m.addAttribute("eventGroup" , new EventGroup());
		return "eventGroupDetail";
	}

	@PostMapping("/eventGroups")
	public String addEventGroup(EventGroup eg) {
		System.err.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"+eg.getName());
		//System.err.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"+eg.getRating());
		//Event event = eventService.getEvent(1);
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		//System.out.println(event);
		User user = userService.findUserByEmail("engg.nayan@yahoo.com");
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.out.println(user);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//Date date = new Date();
		eg.setCreatedOn(new Date());
		eg.setCreatedBy(user);
		//c.setEvent(event);
		eventGroupService.addGroup(eg);
		return "redirect:/eventGroups";
	}
	
	@ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("fullPageMessage");
        return mv;
    }
}