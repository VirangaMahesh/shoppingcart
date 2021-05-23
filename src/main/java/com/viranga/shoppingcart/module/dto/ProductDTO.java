package com.viranga.shoppingcart.module.dto;

import com.viranga.shoppingcart.service.basket.support.CalculatorUtil;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private Integer productID;

    private String productCode;

    private String productName;

    private Long cartonSize;

    private Double cartonPrice;

    private Double perUnitPrice;

    private Double cartonDiscount;

    private Double perUnitMargin;

    public ProductDTO() {
    }


    public ProductDTO(ProductDTO productDTO) {
        this(productDTO.productID, productDTO.productCode, productDTO.productName, productDTO.cartonSize, productDTO.cartonPrice);
    }

    public ProductDTO(Integer productID, String productCode, String productName, Long cartonSize, Double cartonPrice) {
        this.productID = productID;
        this.productCode = productCode;
        this.productName = productName;
        this.cartonSize = cartonSize;
        this.cartonPrice = cartonPrice;
        this.perUnitPrice = CalculatorUtil.perUnitPrice(cartonPrice, cartonSize);
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

    public Long getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(Long cartonSize) {
        this.cartonSize = cartonSize;
    }

    public Double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public Double getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(Double perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
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
