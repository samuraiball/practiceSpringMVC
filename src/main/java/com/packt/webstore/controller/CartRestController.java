package com.packt.webstore.controller;

import com.packt.webstore.Dto.CartDto;
import com.packt.webstore.domain.Cart;
import com.packt.webstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "rest/cart")
public class CartRestController {

    private CartService cartService;


    @Inject
    CartRestController(CartService cartService){
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody CartDto cardDto) {
        cartService.create(cardDto);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody CartDto cartDto) {
        cartDto.setId(cartId);
        cartService.update(cartId, cartDto);
    }


    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void addItem(@PathVariable String productId, HttpSession session) {
        cartService.addItem(session.getId(), productId);

    }

    @RequestMapping(value = "/remove/{productId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeItem(@PathVariable String productId, HttpSession session) {
        cartService.removeItem(session.getId(), productId);
    }
}



