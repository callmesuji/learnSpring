package com.careerit.scart.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.careerit.scart.domain.CartDetails;
import com.careerit.scart.domain.Product;
import com.careerit.scart.service.ProductService;

@Controller
public class ProductWebController {
	@Autowired
	ProductService productService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		return "index";
	}

	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("pid") long pid, HttpSession httpSession) {
		Product product = productService.getProductById(pid);
		if (httpSession.getAttribute("cartItems") == null) {
			List<Product> productList = new ArrayList<>();
			httpSession.setAttribute("cartItems", productList);
		}

		Object object = httpSession.getAttribute("cartItems");
		if (object instanceof List) {
			@SuppressWarnings("unchecked")
			List<Product> productList = (List<Product>) object;
			productList.add(product);
			httpSession.setAttribute("cartItems", productList);
		}
		return "redirect:home";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/viewcartitems")
	public ModelAndView viewCartItems(HttpSession httpSession) {

		List<Product> productList = null;
		Object object = httpSession.getAttribute("cartItems");
		if (object instanceof List) {
			productList = (List<Product>) object;
		}
				
		double totalPrice = 0;
		if (productList != null) {
			totalPrice = productList.stream().mapToDouble(e -> e.getPrice()).sum();
		}
		CartDetails cartDetails = new CartDetails();
		cartDetails.setProducts(productList);
		cartDetails.setTotalPrice(totalPrice);
		ModelAndView obj = new ModelAndView("viewcartitems");
		obj.addObject("cartdetails", cartDetails);
		return obj;
	}
}
