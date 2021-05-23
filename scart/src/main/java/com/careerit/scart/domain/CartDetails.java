package com.careerit.scart.domain;

import java.util.List;

import lombok.Data;
@Data
public class CartDetails {
	private List<Product> products;
	private double totalPrice;
}
