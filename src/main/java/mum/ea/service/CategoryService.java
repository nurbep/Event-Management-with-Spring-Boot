package mum.ea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.ea.domain.Category;
import mum.ea.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;
	}

	public Category getCategory(int categoryId) {
		return categoryRepository.findOne(categoryId);
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}
	
	public void deleteCategory(int categoryId) {
		categoryRepository.delete(categoryId);
	}
}