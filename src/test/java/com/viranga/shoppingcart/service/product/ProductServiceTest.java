package com.viranga.shoppingcart.service.product;

import com.viranga.shoppingcart.module.dto.product.AvailableProductSearchRS;
import com.viranga.shoppingcart.module.dto.product.ProductSearchRQ;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void getAvailableProducts() {
        ProductSearchRQ searchRQ = new ProductSearchRQ();
        searchRQ.setSearchKeyWord("");
        AvailableProductSearchRS productSearchRS = productService.getAvailableProducts(searchRQ);

        Assert.assertFalse(productSearchRS.getProducts().isEmpty());
    }

    @Test
    void getUnAvailableProductsWithDescription() {
        ProductSearchRQ searchRQ = new ProductSearchRQ();
        searchRQ.setSearchKeyWord("Axil");
        AvailableProductSearchRS productSearchRS = productService.getAvailableProducts(searchRQ);

        Assert.assertTrue(productSearchRS.getProducts().isEmpty());
    }

    @Test
    void getAvailableProductsWithDescription() {
        ProductSearchRQ searchRQ = new ProductSearchRQ();
        searchRQ.setSearchKeyWord("Surgical");
        AvailableProductSearchRS productSearchRS = productService.getAvailableProducts(searchRQ);

        Assert.assertFalse(productSearchRS.getProducts().isEmpty());
    }

    @Test
    void getAvailableProductsWithCode() {
        ProductSearchRQ searchRQ = new ProductSearchRQ();
        searchRQ.setSearchKeyWord("0000006");
        AvailableProductSearchRS productSearchRS = productService.getAvailableProducts(searchRQ);

        Assert.assertFalse(productSearchRS.getProducts().isEmpty());
        Assert.assertEquals(productSearchRS.getProducts().size(), 1);
    }
}
