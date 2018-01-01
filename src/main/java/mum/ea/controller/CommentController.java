package mum.ea.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.config.GetCurrentUser;
import mum.ea.domain.Building;
import mum.ea.domain.Comment;
import mum.ea.domain.Event;
import mum.ea.domain.FacilityType;
import mum.ea.domain.User;
import mum.ea.service.BuildingService;
import mum.ea.service.CommentService;
import mum.ea.service.EventService;
import mum.ea.service.UserServiceImpl;

@Controller
public class CommentController {
	
	@Autowired
	GetCurrentUser getCurrentUser;
	
	//private User user = (User)getCurrentUser.getUser();
	@Autowired
	EventService eventService;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	private CommentService commentService;

	@GetMapping("/comments")
	public String getComments(Model m) {
		m.addAttribute("comments", commentService.getAllComments());
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		System.out.println( commentService.getAllComments());
		return "commentList";
	}

	@GetMapping("/comments/{id}")
	public String getComment(@PathVariable int id, Model m) {
		
		m.addAttribute("comment", commentService.getComment(id));
		return "commentDetail";
	}
	
	
	
	@GetMapping("/addComment")
	public String addCommentView(Model m) {
		m.addAttribute("comment" , new Comment());
		return "commentDetail";
	}

	@PostMapping("/saveEventComment/{id}")
	public String saveEventComment(@PathVariable int id, Comment c, Event event) {
		
		//Event e = eventService.getEvent(1);
		User user = userService.findUserByEmail(getCurrentUser.getLoggedInUserName());
		c.setUser(user);
		c.setEvent(event);
		c.setCommentDate(new Date());
		System.out.println("CCCCCCCCCCCCCCc");
		System.out.println(c);
		System.out.println("CCCCCCCCCCCCCc");
		
		commentService.addComment(c);
		return "redirect:/eventDetail/"+event.getId();
	}
	
	@GetMapping("/addComment/{id}")
	public String addNewComment(@PathVariable int id, Model m) {
		Event event = eventService.getEvent(id);
		User user = userService.findUserByEmail(getCurrentUser.getLoggedInUserName());
		Comment comment = new Comment();
		comment.setEvent(event);
		comment.setUser(user);
		m.addAttribute("comment", comment);
		m.addAttribute("event", event);
		//m.addAttribute("event", eventService.getEvent(id));
		return "commentDetail";
	}
	
	/*@PostMapping("/comments")
	public String addComment(Comment c) {
		System.err.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"+c.getDescription());
		System.err.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"+c.getRating());
		Event event = eventService.getEvent(1);
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		System.out.println(event);
		User user = userService.findUserByEmail("engg.nayan@yahoo.com");
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.out.println(user);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		c.setCommentDate(new Date());
		c.setUser(user);
		c.setEvent(event);
		commentService.addComment(c);
		return "redirect:/comments";
	}*/
	
	/**@Autowired
	private CommentService commentService;
	
	@RequestMapping("/comments")
	public List<Comment> getComments() {
		return commentService.getAllComments();
	}
	
	@RequestMapping("/comments/{id}")
	public Comment getComment(@PathVariable int id) {
		return commentService.getComment(id);
	}**/
	
	@ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("fullPageMessage");
        return mv;
    }

}
