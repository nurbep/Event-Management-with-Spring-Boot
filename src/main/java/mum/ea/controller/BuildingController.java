package mum.ea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.Building;
import mum.ea.domain.FacilityType;
import mum.ea.service.BuildingService;

@Controller
@RequestMapping(value = "/admin")
public class BuildingController {	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping("/buildings")
	public String getBuildings(Model m) {
		m.addAttribute("buildings", buildingService.getAllBuildings());
		return "buildingList";
	}

	@GetMapping("/buildings/{id}")
	public String getBuilding(@PathVariable int id, Model m) {
		List<FacilityType> types = new ArrayList<FacilityType>(Arrays.asList(FacilityType.values()));

		m.addAttribute("buildingTypes", types);
		m.addAttribute("building", buildingService.getBuilding(id));
		return "buildingDetail";
	}

	@GetMapping("/addBuilding")
	public String addBuildingView(Model m) {
		m.addAttribute("building", new Building());
		return "buildingDetail";
	}

	@PostMapping("/buildings")
	public String addBuilding(@Valid Building b) {
		buildingService.addBuilding(b);
		return "redirect:/admin/buildings";
	}

	@PostMapping("/buildings/{id}")
	public String updateBuilding(Building b) {
		buildingService.updateBuilding(b);
		return "redirect:/admin/buildings";
	}

	@PostMapping("/buildings/delete/{id}")
	public String deleteBuilding(Building b) {
		buildingService.deleteBuilding(b.getId());
		return "redirect:/admin/buildings";
	}

	@ExceptionHandler(value = NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("fullPageMessage");
		return mv;
	}

}
