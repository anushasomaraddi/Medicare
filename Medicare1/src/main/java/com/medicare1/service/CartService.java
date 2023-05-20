package com.medicare1.service;

import java.util.List;

import com.medicare1.entity.Cart;

public interface CartService {
	
	public Cart addToCart(Cart cart);
	
	public List<Cart> getAllByUserCart(long id);
	
	public void deleteCart(long id);
	
	public void updateCart(Cart cart, long cid);

}
