package mum.ea.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.Category;
import mum.ea.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public String getCategories(Model m) {
		m.addAttribute("categories", categoryService.getAllCategories());
		return "categoryList";
	}
	
	@GetMapping("/categories/{id}")
	public String getCategory(@PathVariable int id, Model m) {
		m.addAttribute("category", categoryService.getCategory(id));
		return "categoryDetail";
	}
	
	@GetMapping("/addCategory")
	public String addCategoryView(Model m) {
		m.addAttribute("category" , new Category());
		return "categoryDetail";
	}

	@PostMapping("/categories")
	public String addCategory(@Valid Category c, BindingResult result) {
		if (result.hasErrors()) {
            return "addCategory";
        } else {
		categoryService.addCategory(c);
		return "redirect:/categories";
        }
	}

	@PostMapping("/categories/{id}")
	public String updateCategory(@Valid Category c, BindingResult result) {
		if (result.hasErrors()) {
            return "categoryDetail";
        } else {
		categoryService.updateCategory(c);
		return "redirect:/categories";
        }
	}
	@PostMapping("/categories/delete/{id}")
	public String deleteCategory(Category c) {
		categoryService.deleteCategory(c.getId());
		return "redirect:/categories";
	}
	
	@ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("fullPageMessage");
        return mv;
    }
}