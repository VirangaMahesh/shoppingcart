package com.viranga.shoppingcart.service.basket;

import com.viranga.shoppingcart.module.dto.BasketCalculateRQ;
import com.viranga.shoppingcart.module.dto.BasketCalculateRS;
import com.viranga.shoppingcart.module.dto.BasketItemDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class BasketServiceTest {

    @Autowired
    private BasketService basketService;

    @Test
    void calculateBasketValueWithLessQty() {
        BasketCalculateRQ calculateRQ = new BasketCalculateRQ();
        calculateRQ.addBasketItemList(new BasketItemDTO(1, 10L));
        BasketCalculateRS basketCalculateRS = basketService.calculateBasketValue(calculateRQ);
        Assert.assertEquals(basketCalculateRS.getTotalBasketAmount(), basketCalculateRS.getTotalNetAmount());
    }

    @Test
    void calculateBasketValueUnitPrice() {
        BasketCalculateRQ calculateRQ = new BasketCalculateRQ();
        calculateRQ.addBasketItemList(new BasketItemDTO(1, 1L));
        BasketCalculateRS basketCalculateRS = basketService.calculateBasketValue(calculateRQ);
        Assert.assertTrue(basketCalculateRS.getTotalNetAmount() > 1.0);
        Assert.assertTrue(basketCalculateRS.getTotalNetAmount() == 1.3);

    }

    @Test
    void calculateBasketValueDiscount() {
        BasketCalculateRQ calculateRQ = new BasketCalculateRQ();
        calculateRQ.addBasketItemList(new BasketItemDTO(1, 144L * 3 + 2));
        BasketCalculateRS basketCalculateRS = basketService.calculateBasketValue(calculateRQ);
        Assert.assertTrue(basketCalculateRS.getTotalDiscountAmount() > 0.0);
    }
}
