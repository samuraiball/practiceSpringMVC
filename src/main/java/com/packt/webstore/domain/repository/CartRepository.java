package com.packt.webstore.domain.repository;

import com.packt.webstore.Dto.CartDto;
import com.packt.webstore.domain.Cart;

public interface CartRepository {

    //for spring web flow
    void clearCart(String cartId);

    //CRUD
    void create(CartDto cartDto);
    Cart read(String id);
    void update(String id, CartDto cartDto);
    void delete(String id);

    void addItem(String cartId, String productId);
    void removeItem(String cartId, String productId);
}
