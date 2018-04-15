package com.packt.webstore.service;

import com.packt.webstore.Dto.CartDto;
import com.packt.webstore.domain.Cart;

public interface CartService {

    Cart validate(String cartId);
    void clearCart(String cartId);

    void create(CartDto cartDto);
    Cart read(String cartId);
    void update(String cartId, CartDto cartDto);
    void delete(String id);
    void addItem(String cartId, String productId);
    void removeItem(String cartId, String productId);
}
