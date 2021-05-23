package com.viranga.shoppingcart.module.dto.product;

import com.viranga.shoppingcart.module.dto.ProductDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AvailableProductSearchRS implements Serializable {

    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
