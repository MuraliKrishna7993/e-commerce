package com.test.ecommerse.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.ecommerse.model.Category;
import com.test.ecommerse.repository.CategoryRepository;
import com.test.ecommerse.serviceImplementation.CategoryServiceImplementation;

@SpringBootTest(classes = { CategoryServiceTest.class })
public class CategoryServiceTest {
	@Mock
	CategoryRepository categoryRepo;

	@InjectMocks
	CategoryServiceImplementation categoryServiceImpl;

	@Test
	@Order(2)

	public void test_listCategories() {

		List<Category> categories = new ArrayList<Category>();

		categories.add(new Category(1, "Mobiles"));

		categories.add(new Category(2, "Watches"));

		categories.add(new Category(3, "Laptops"));

		categories.add(new Category(4, "Tv"));

		when(categoryRepo.findAll()).thenReturn(categories);

		assertEquals(4, categoryServiceImpl.listCategories().size());

	}

	@Test

	@Order(1)

	public void test_getSingleCategory() {

		List<Category> categories = new ArrayList<Category>();

		categories.add(new Category(1, "Mobiles"));

		categories.add(new Category(2, "Watches"));

		categories.add(new Category(3, "Laptops"));

		categories.add(new Category(4, "Tv"));

		int categoryId = 1;

		when(categoryRepo.findAll()).thenReturn(categories);

		assertEquals(categoryId, categoryServiceImpl.getSingleCategory(categoryId).getCategoryId());

	}
}
