package com.careerit.scart.domain;

import lombok.Data;

@Data
public class Product {
	private long pid;
	private String name;
	private String description;
	private double price;

}
