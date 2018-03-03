package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.packt.webstore.Dto.CartDto;
import com.packt.webstore.Dto.CartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.CartRepository;
import com.packt.webstore.service.ProductService;

@Repository
public class InMemoryCartRepository implements CartRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private ProductService productService;

    @Override
    public void create(CartDto cartDto) {
        String INSERT_CART_SQL = "INSERT INTO CART(ID) VALUES(:id)";
        Map<String, Object> cartParams = new HashMap<String, Object>();
        cartParams.put("id", cartDto.getId());
        jdbcTemplate.update(INSERT_CART_SQL, cartParams);

        cartDto.getCartItems().stream().forEach(cartItemDto -> {
            Product productById = productService.getProduct(cartItemDto.getProductId());
            String INSET_CART_ITEM_SQL = "INSET INTO CART_ITEM(ID, PRODUCT_ID, CART_ID, QUANTITY)" +
                    "VALUES(:id, , :product_id, :cart_Id, :quantity)";
            Map<String, Object> cartItemParams = new HashMap<String, Object>();
            cartItemParams.put("id", cartItemDto.getId());
            cartItemParams.put("product_id", cartItemDto.getProductId());
            cartItemParams.put("cart_id", cartDto.getId());
            cartItemParams.put("quantity", cartItemDto.getQuantity());
            jdbcTemplate.update(INSET_CART_ITEM_SQL, cartItemParams);

        });
    }

    @Override
    public Cart read(String id) {
        String SQL = "SELECT * FROM CART WHERE ID= :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        CartMapper cartMapper = new CartMapper(jdbcTemplate, productService);
        try {
            return jdbcTemplate.queryForObject(SQL, params, cartMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(String id, CartDto cartDto) {
        List<CartItemDto> cartItems = cartDto.getCartItems();
        for (CartItemDto cartItem : cartItems) {
            String SQL = "UPDATE CART_ITEM SET QUANTITY = :quantity, PRODUCT_ID, : productId" +
                    "WHERE ID = :id AND CART_ID = : cart_id";

            Map<String, Object> params = new HashMap<>();
            params.put("id", cartItem.getId());
            params.put("quantity", cartItem.getQuantity());
            params.put("productId", cartItem.getProductId());
            params.put("cartId", id);
            jdbcTemplate.update(SQL, params);
        }
    }

    @Override
    public void delete(String id) {
        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE CART_ITEM WHERE CART_ID = :id";
        String SQL_DELETE_CART = "DELETE FROM CART WHERE CART_ID = ID";
        Map<String, Object> params = new HashMap<>();

        params.put("id", id);

        jdbcTemplate.update(SQL_DELETE_CART_ITEM, params);
        jdbcTemplate.update(SQL_DELETE_CART, params);
    }

    @Override
    public void addItem(String cartId, String productId) {
        String SQL = null;
        Cart cart = null;
        cart = read(cartId);

        if (cart == null) {
            CartItemDto newCartItemDto = new CartItemDto();
            newCartItemDto.setId(cartId + productId);
            newCartItemDto.setProductId(productId);
            newCartItemDto.setQuantity(1);

            CartDto newCartDto = new CartDto(cartId);
            newCartDto.addCartItem(newCartItemDto);
            create(newCartDto);

            return;
        }

        Map<String, Object> cartItemParams = new HashMap<>();

        if (cart.getItemByProductId(productId) == null) {
            SQL = "INSERT INTO CART_ITEM (ID, PRODUCT_ID, CART_ID, QUANTITY)" +
                    "VALUES (:id, :productId, :cardId, :quantity)";
            cartItemParams.put("id", cartId + productId);
            cartItemParams.put("quantity", 1);
        } else {

            SQL = "UPDATE CART_ITEM SET QUANTITY =:quantity " +
                    "WHERE CART_ID = :cartId AND PRODUCT_ID =:productId ";
            CartItem existingItem = cart.getItemByProductId(productId);

            cartItemParams.put("id", existingItem.getId());
            cartItemParams.put("quantity", existingItem.getQuantity() + 1);
        }

        cartItemParams.put("productId", productId);
        cartItemParams.put("cartId", cartId);
        jdbcTemplate.update(SQL, cartItemParams);
    }


    @Override
    public void removeItem(String cartId, String productId) {

        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE PRODUCT_ID = :productId AND CART_ID =:id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", cartId);
        params.put("productId", productId);
        jdbcTemplate.update(SQL_DELETE_CART_ITEM, params);
    }
}

