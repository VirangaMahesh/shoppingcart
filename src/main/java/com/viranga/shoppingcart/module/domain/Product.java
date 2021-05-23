package com.viranga.shoppingcart.module.domain;
/*
@Entity
@Table(name = "T_ROLE")*/
public class Product {

    private Integer productID;

    private String productCode;

    private Double cartonSize;

    private Double cartonPrice;

    private Double cartonDiscount;

    private Double perUnitMargin;

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

    public Double getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(Double cartonSize) {
        this.cartonSize = cartonSize;
    }

    public Double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public Double getCartonDiscount() {
        return cartonDiscount;
    }

    public void setCartonDiscount(Double cartonDiscount) {
        this.cartonDiscount = cartonDiscount;
    }

    public Double getPerUnitMargin() {
        return perUnitMargin;
    }

    public void setPerUnitMargin(Double perUnitMargin) {
        this.perUnitMargin = perUnitMargin;
    }
}
