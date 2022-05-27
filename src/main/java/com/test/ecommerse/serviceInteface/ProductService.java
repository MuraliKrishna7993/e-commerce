package com.test.ecommerse.serviceInteface;

import java.util.List;

import com.test.ecommerse.model.Product;

public interface ProductService {
	Product createProduct(Product product);

	List<Product> listProducts();

	Product getSingleProduct(Integer ProductId);

	void deleteProduct(Integer ProductId);

	Product editProduct(Product updateProduct);

}
