package com.careerit.scart.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.careerit.scart.domain.Product;

@SpringBootTest
public class ProductDaoTest {
	@Autowired
	private ProductDao productDao;
	@BeforeEach
	void init() {
		productDao.deleteProduct();
		
	}
	
	 
	@Test
	public void insertProductTest() {
		Product product = new Product();
		product.setName("ASUS ROG");
		product.setDescription("With i7 and 32 RAM");
		product.setPrice(890000); 
		long newId = productDao.insertProduct(product);
		assertTrue(newId != 0);
		List<Product> list = productDao.selectAllProducts();
		assertEquals(1, list.size());

	}
	@Test
	public void selectProducts() {
		
	}

}
