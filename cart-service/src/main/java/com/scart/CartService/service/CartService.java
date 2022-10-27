package com.scart.CartService.service;

import com.scart.CartService.exception.CartException;
import com.scart.CartService.model.Cart;

import java.util.List;

public interface CartService {
    public Cart getCartById(int cartId) throws CartException;
    public Cart updateCart(int cartId, Cart cart) throws CartException;
    public List<Cart> getAllCarts() throws CartException;
    public double cartTotal(Cart total);
    public Cart addCart(Cart cart);
}
