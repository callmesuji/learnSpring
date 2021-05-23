package com.careerit.scart.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.scart.domain.Product;
import com.careerit.scart.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/search/{str}")
	public List<Product> search(@PathVariable("id") String str) {

		return productService.search(str);
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") long id) {
		return productService.getProductById(id);

	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PostMapping("/addall")
	public List<Product> addProducts(List<Product> products) {
		return null;
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@PutMapping("/updateall")
	public List<Product> updateProducts(@RequestBody List<Product> products) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok("SUCCESSFULLY DELETED");
	}

}
