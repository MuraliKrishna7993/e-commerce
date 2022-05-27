package com.test.ecommerse.serviceInteface;

import java.util.List;

import com.test.ecommerse.model.Category;

public interface CategoryService {

	Category createCategory(Category category);

	List<Category> listCategories();

	Category getSingleCategory(Integer categoryId);

	void deleteCategory(Integer categoryId);

	Category editCategory(Category category);

}
