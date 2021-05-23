package com.viranga.shoppingcart.module.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BasketCalculateRS implements Serializable {

    private Double totalBasketAmount;

    private Double totalDiscountAmount;

    private Double totalNetAmount;

    private List<BasketItemDTO> basketItemDTOList;

    public List<BasketItemDTO> getBasketItemDTOList() {
        if (basketItemDTOList == null) {
            basketItemDTOList = new ArrayList<>();
        }
        return basketItemDTOList;
    }

    public void setBasketItemDTOList(List<BasketItemDTO> basketItemDTOList) {
        this.basketItemDTOList = basketItemDTOList;
    }

    public void addBasketItemDTO(BasketItemDTO basketItemDTO) {
        this.getBasketItemDTOList().add(basketItemDTO);
    }

    public Double getTotalBasketAmount() {
        if (totalBasketAmount == null) {
            totalBasketAmount = 0.0;
        }
        return totalBasketAmount;
    }

    public void setTotalBasketAmount(Double totalBasketAmount) {
        this.totalBasketAmount = totalBasketAmount;
    }

    public void addTotalBasketAmount(Double totalBasketAmount) {
        this.setTotalBasketAmount(this.getTotalBasketAmount() + totalBasketAmount);
    }

    public Double getTotalDiscountAmount() {
        if (totalDiscountAmount == null) {
            totalDiscountAmount = 0.0;
        }
        return totalDiscountAmount;
    }

    public void setTotalDiscountAmount(Double totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }


    public void addTotalDiscountAmount(Double totalDiscountAmount) {
        this.setTotalDiscountAmount(this.getTotalDiscountAmount() + totalDiscountAmount);
    }

    public Double getTotalNetAmount() {
        if (totalNetAmount == null) {
            totalNetAmount = 0.0;
        }
        return totalNetAmount;
    }

    public void setTotalNetAmount(Double totalNetAmount) {
        this.totalNetAmount = totalNetAmount;
    }

    public void addTotalNetAmount(Double totalNetAmount) {
        this.setTotalNetAmount(this.getTotalNetAmount() + totalNetAmount);
    }
}
