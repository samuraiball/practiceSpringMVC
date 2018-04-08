package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @RequestMapping
    public String get(HttpServletRequest httpServletRequest) {
        return "redirect:/cart/" + httpServletRequest.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable String cartId, Model model){
        model.addAttribute("cartId",cartId);
        return "cart";
    }
}
