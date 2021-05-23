package com.careerit.scart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.scart.dao.ProductDao;
import com.careerit.scart.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductDao productDao;

	@Override
	public Product addProduct(Product product) {
		Assert.notNull(product, "Product cant be null");
		Assert.notNull(product.getName(), "name can't be null");
		long id = productDao.insertProduct(product);
		product.setPid(id);
		LOGGER.info("product is added with id{}", id);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productDao.selectAllProducts();
		LOGGER.info("total products found in db {}", productList.size());
		return productList;

	}

	@Override
	public Product getProductById(long pid) {
		Product product = productDao.selectProductById(pid);
		return product;
	}

	@Override
	public List<Product> search(String str) {
		List<Product> productList = productDao.search(str);
		return productList;
	}

	@Override
	public Product updateProduct(Product product) {
		Assert.notNull(product, "Product cant be null");
		Assert.notNull(product.getPid(), "id can't be null");
		long id = productDao.updateProduct(product);
		if (id == 0) {
			LOGGER.info("product with id {} not able to update", product.getPid());
		}

		return product;
	}

	@Override
	public boolean deleteProduct(long pid) {
		boolean success;

		success = productDao.deleteProduct(pid);

		return success;
	}

	@Override
	public long addProducts(List<Product> products) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long updateProducts(List<Product> products) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub

	}

}
