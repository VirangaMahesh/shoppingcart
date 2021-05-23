package com.viranga.shoppingcart.service.basket;

import com.viranga.shoppingcart.dao.ProductDao;
import com.viranga.shoppingcart.module.dto.BasketCalculateRQ;
import com.viranga.shoppingcart.module.dto.BasketCalculateRS;
import com.viranga.shoppingcart.service.basket.support.BasketPriceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasketService {

    @Autowired
    private ProductDao productDao;

    private static final Logger LOG = LoggerFactory.getLogger(BasketService.class);

    @Transactional(propagation = Propagation.SUPPORTS)
    public BasketCalculateRS calculateBasketValue(BasketCalculateRQ calculateRQ) {
        LOG.info("START: Calculate basket price : {}", calculateRQ);
        BasketCalculateRS result = new BasketPriceBuilder(calculateRQ)
                .setProductDao(productDao)
                .loadProducts()
                .calculateItemWisePrice()
                .getBasketCalculateRs();
        LOG.info("END: Calculate basket price : {}", calculateRQ);
        return result;
    }

}
