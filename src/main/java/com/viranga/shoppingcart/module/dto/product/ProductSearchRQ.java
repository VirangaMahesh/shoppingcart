package com.viranga.shoppingcart.module.dto.product;

import java.io.Serializable;

public class ProductSearchRQ implements Serializable {

    private String searchKeyWord;

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    @Override
    public String toString() {
        return "ProductSearchRQ{" +
                "searchKeyWord='" + searchKeyWord + '\'' +
                '}';
    }
}
