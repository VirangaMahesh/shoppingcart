package com.viranga.shoppingcart.module.dto;

import java.io.Serializable;

public class BasketItemDTO implements Serializable {

    private Integer productID;

    private String productCode;

    private String productName;

    private Long purchaseQuantity;

    private Double price;

    private Double discount;

    private Double netPrice;

    public BasketItemDTO() {
    }

    public BasketItemDTO(Integer productID,  Long purchaseQuantity) {
        this.productID = productID;
        this.purchaseQuantity = purchaseQuantity;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPurchaseQuantity() {
        if (purchaseQuantity == null) {
            purchaseQuantity = 0L;
        }
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Long purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    @Override
    public String toString() {
        return "BasketItemDTO{" +
                "productCode='" + productCode + '\'' +
                ", purchaseQuantity=" + purchaseQuantity +
                ", price=" + price +
                ", discount=" + discount +
                ", netPrice=" + netPrice +
                '}';
    }
}
