package com.test.ecommerse.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ecommerse.model.Category;
import com.test.ecommerse.repository.CategoryRepository;
import com.test.ecommerse.serviceInteface.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	CategoryRepository categoryrepo;

	public Category createCategory(Category category) {

		return categoryrepo.insert(category);
	}

	public List<Category> listCategories() {

		return categoryrepo.findAll();

	}

	/*
	 * public Category getSingleCategory(Integer categoryId) { Optional<Category>
	 * category = categoryrepo.findById(categoryId); if (category.isPresent()) {
	 * return category.get(); } else { throw new
	 * RuntimeException("Product not Found"); } }
	 */

	public Category getSingleCategory(Integer categoryId) {

		List<Category> categories = categoryrepo.findAll();

		Category category = null;

		for (Category cat : categories) {

			if (cat.getCategoryId() == categoryId)

				category = cat;

		}

		return category;

	}

	public void deleteCategory(Integer categoryId) {
		categoryrepo.deleteById(categoryId);

	}

	public Category editCategory(Category category) {

		return categoryrepo.save(category);
	}

}
