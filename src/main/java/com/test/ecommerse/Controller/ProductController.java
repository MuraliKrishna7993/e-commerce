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

import com.test.ecommerse.model.Product;
import com.test.ecommerse.serviceImplementation.ProductServiceImplementation;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImplementation productserviceimpl;

	/* Saves Product Details in database */
	@PostMapping("/addProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productserviceimpl.createProduct(product);
	}

	/* Fetches all Products from Database */
	@GetMapping("/Products")
	public List<Product> listAllProducts() {
		return productserviceimpl.listProducts();
	}

	/* Fetches Specific Product details from Database based on Id */
	@GetMapping("/Products/Oneproduct/{ProductId}")
	public Product getProduct(@PathVariable Integer ProductId) {

		return productserviceimpl.getSingleProduct(ProductId);
	}

	/* deletes Specific Product from Database based on its Id */
	@DeleteMapping("/Products")
	public void deleteProduct(@RequestParam Integer productId) {
		productserviceimpl.deleteProduct(productId);
	}

	@GetMapping("/Products/productName")
	public List<Product> getProductByproductName(@RequestParam(name = "productName") String productName) {
		return productserviceimpl.getProductByproductName(productName);

	}

	/* Updates Product Details */
	@PutMapping("/Products/{productId}")
	public Product updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
		product.setProductId(productId);
		return productserviceimpl.editProduct(product);

	}

	@GetMapping("/Products/{categoryName}")
	public List<Product> getProductBycategoryName(@PathVariable String categoryName) {
		return productserviceimpl.getProductBycategoryName(categoryName);
	}

	@GetMapping("Products/{categoryName}/{productName}")
	public List<Product> getProductBycategoryNameandproductName(
			@PathVariable(value = "categoryName") String categoryName,
			@PathVariable(value = "productName") String productName) {
		return productserviceimpl.getProductBycategoryNameandproductName(categoryName, productName);
	}

	// @GetMapping("/categoryNameandproductName")
	// public List<Product>
	// getProductBycategoryNameandproductName(@RequestParam(name="categoryName")
	// String categoryName,
	// @RequestParam(name="productName") String productName)
	// {
	// return
	// productserviceimpl.getProductBycategoryNameandproductName(categoryName,
	// productName);}

	// @GetMapping("/Products/categoryName")
	// public List<Product>
	// getProductBycategoryName(@RequestParam(name="categoryName") String
	// categoryName) {
	// return productserviceimpl.getProductBycategoryName(categoryName);}

}
