package com.careerit.scart.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.careerit.scart.domain.Product;
import com.careerit.scart.service.ProductService;

@Controller
public class ProductAdminController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = { "/admin/addProduct" }, method = RequestMethod.GET)
	public String addAdmin(Model model) {
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		return "addProduct";
	}
	
	//--------------------------------------------------------------------------------
	
	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String viewAdmin(Model model) {
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		return "admin";
	}
	//--------------------------------------------------------------------------------


//	@PutMapping("/updateproduct")
//	public String updateProduct(@RequestParam("pid") long pid) {
//		Product product = productService.updateProduct(null);
//		return null;
//	}
	
//					 deleting product
	@RequestMapping(value = "/deleteproduct/{pid}")
	public ModelAndView DeleteProduct(@PathVariable("pid") long pid) {
		productService.deleteProduct(pid);
		return new ModelAndView("redirect:/admin");
	}
//                    updating product
	
	@RequestMapping(value = "/admin/updateproduct/{pid}")
	public ModelAndView UpdateProduct(@ModelAttribute("product") Product product, @PathVariable("pid") long pid) {
		ModelAndView model = new ModelAndView("products");

		product = productService.getProductById(pid);
		List<Product> productList = productService.getAllProducts();
		model.addObject("product", product);
		model.addObject("productList", productList);

		return model;
	}
//                       adding product
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product) {
		try {
			if (productService.getProductById(product.getPid()) != null);
			productService.addProduct(product);

		} catch (EmptyResultDataAccessException e) {
			productService.updateProduct(product);
		}

		return new ModelAndView("redirect:/admin");

	}

}
