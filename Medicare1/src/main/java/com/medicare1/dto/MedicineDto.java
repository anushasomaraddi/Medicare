package com.medicare1.dto;

public class MedicineDto {
	
	private long id;
	private String name;
	private double price;
	private String url;
	private String category;
	private int quantity;
	
	
	public MedicineDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MedicineDto(long id, String name, double price, String url, String category, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.url = url;
		this.category = category;
		this.quantity = quantity;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
