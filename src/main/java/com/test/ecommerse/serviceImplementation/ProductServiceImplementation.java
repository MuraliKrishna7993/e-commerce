package com.test.ecommerse.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ecommerse.model.Product;
import com.test.ecommerse.repository.ProductRepository;
import com.test.ecommerse.serviceInteface.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	ProductRepository productRepo;

	public Product createProduct(Product product) {
		return productRepo.insert(product);
	}

	public List<Product> listProducts() {
		return productRepo.findAll();
	}

	public Product getSingleProduct(Integer ProductId) {
		Optional<Product> product = productRepo.findById(ProductId);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new RuntimeException("Product not Found");
		}
	}

	public void deleteProduct(Integer ProductId) {

		productRepo.deleteById(ProductId);
	}

	public Product editProduct(Product updateProduct) {
		return productRepo.save(updateProduct);
	}

	public List<Product> getProductByproductName(String productName) {
		return productRepo.findByProductName(productName);
	}

	public List<Product> getProductBycategoryName(String categoryName) {
		return productRepo.findByCategoryCategoryName(categoryName);
	}

	public List<Product> getProductBycategoryNameandproductName(String categoryName, String productName) {
		return productRepo.findByCategoryCategoryNameAndProductName(categoryName, productName);
	}

}
