package com.medicare1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare1.entity.Cart;
import com.medicare1.entity.Medicine;
import com.medicare1.entity.User;
import com.medicare1.service.CartService;
import com.medicare1.service.MedicineService;
import com.medicare1.service.UserService;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/cart")
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("getall/{userId}")
	public List<Cart> getCart(@PathVariable long userId) {
		return cartService.getAllByUserCart(userId);
	}

	@GetMapping("/add/{medicineId}/{userId}")
	public ResponseEntity<Cart> addCart(@PathVariable long medicineId,@PathVariable long userId) {

		Medicine medicine = medicineService.getMedicineById(medicineId);
		User user = userService.getUserById(userId);
		Cart cart = new Cart(user, medicine);
		cart.setUnit(1);
		cart.setTotalPrice(cart.getUnit()*medicine.getPrice());
		Cart addCart = cartService.addToCart(cart);
		return new ResponseEntity<Cart>(addCart, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<?> deletCart(@PathVariable long cartId) {

		cartService.deleteCart(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update-cart/{cid}")
	public void updateCart(@RequestBody Cart cart, @PathVariable long cid) {
		cartService.updateCart(cart, cid);
		
	}

}
