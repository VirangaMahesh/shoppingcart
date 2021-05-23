package com.viranga.shoppingcart.module.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BasketCalculateRQ implements Serializable {

    private List<BasketItemDTO> basketItemList;

    public List<BasketItemDTO> getBasketItemList() {
        if (basketItemList == null) {
            basketItemList = new ArrayList<>();
        }
        return basketItemList;
    }

    public void setBasketItemList(List<BasketItemDTO> basketItemList) {
        this.basketItemList = basketItemList;
    }

    public void addBasketItemList(BasketItemDTO basketItem) {
        this.getBasketItemList().add(basketItem);
    }

    @Override
    public String toString() {
        return "BasketCalculateRQ{" +
                "basketItemList=" + basketItemList +
                '}';
    }
}
