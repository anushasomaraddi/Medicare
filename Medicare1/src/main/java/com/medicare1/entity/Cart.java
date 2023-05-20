package com.medicare1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name= "user_id")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "medicine_id")
	private Medicine medicine;
	
	public Cart(User user, Medicine medicine) {
		this.user = user;
		this.medicine = medicine;
	}
	
	private Integer unit;
	
	private double totalPrice;

	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cart(long id, User user, Medicine medicine, Integer unit, double totalPrice) {
		super();
		this.id = id;
		this.user = user;
		this.medicine = medicine;
		this.unit = unit;
		this.totalPrice = totalPrice;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Medicine getMedicine() {
		return medicine;
	}



	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}



	public Integer getUnit() {
		return unit;
	}



	public void setUnit(Integer unit) {
		this.unit = unit;
	}



	public double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	




}
