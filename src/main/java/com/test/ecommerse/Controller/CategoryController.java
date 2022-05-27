package com.test.ecommerse.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.ecommerse.model.Category;
import com.test.ecommerse.serviceImplementation.CategoryServiceImplementation;

@RestController
public class CategoryController {

	@Autowired
	CategoryServiceImplementation categoryserviceimpl;

	@PostMapping("/addCategory")
	public Category saveCategory(@RequestBody Category category) {
		return categoryserviceimpl.createCategory(category);
	}

	@GetMapping("/Categories")
	public List<Category> listAllCategories() {
		return categoryserviceimpl.listCategories();
	}

	@GetMapping("/Categories/{categoryId}")
	public Category getCategory(@PathVariable Integer categoryId) {
		return categoryserviceimpl.getSingleCategory(categoryId);
	}

	@DeleteMapping("/Categories")
	public void deleteCategory(@RequestParam Integer categoryId) {
		categoryserviceimpl.deleteCategory(categoryId);
	}

	@PutMapping("/Categories/{categoryId}")
	public Category updateCategory(@PathVariable Integer categoryId, @RequestBody Category category) {
		category.setCategoryId(categoryId);
		return categoryserviceimpl.editCategory(category);

	}
}
