package com.careerit.scart.service;

import java.util.List;

import com.careerit.scart.domain.Product;

public interface ProductService {
	
	Product addProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(long pid);

	List<Product> search(String str);

	Product updateProduct(Product product);

	boolean deleteProduct(long pid);

	long addProducts(List<Product> products);

	long updateProducts(List<Product> products);

	void deleteProduct();
	

}
