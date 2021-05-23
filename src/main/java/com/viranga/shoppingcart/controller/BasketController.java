package com.viranga.shoppingcart.controller;

import com.viranga.shoppingcart.module.dto.BasketCalculateRQ;
import com.viranga.shoppingcart.module.dto.BasketCalculateRS;
import com.viranga.shoppingcart.module.dto.common.ResponseDTO;
import com.viranga.shoppingcart.service.basket.BasketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/basket")
public class BasketController {

    private static final Logger LOG = LoggerFactory.getLogger(BasketController.class);

    @Autowired
    private BasketService basketService;

    @RequestMapping(value = "/calculateBasketValue", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseDTO<BasketCalculateRS> calculateBasketValue(@RequestBody BasketCalculateRQ calculateRQ) {
        BasketCalculateRS response = null;
        LOG.info("START :Calculate basket value : {}", calculateRQ);
        response = basketService.calculateBasketValue(calculateRQ);
        LOG.info("END :Calculate basket value : {}", calculateRQ);

        return new ResponseDTO<>(response);
    }

}
