package com.careerit.scart.dao;

import java.util.List;

import com.careerit.scart.domain.Product;

public interface ProductDao {

	long insertProduct(Product product);

	List<Product> selectAllProducts();

	Product selectProductById(long pid);
	
	List<Product> search(String str);
	
	long updateProduct(Product product);
	
	boolean deleteProduct(long pid);
	
	long insertProducts(List<Product> products);
	
	long updateProducts(List<Product> products);
	
	void deleteProduct();
	
	

}
