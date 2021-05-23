package com.viranga.shoppingcart.controller;

import com.viranga.shoppingcart.module.dto.common.ResponseDTO;
import com.viranga.shoppingcart.module.dto.product.AvailableProductSearchRS;
import com.viranga.shoppingcart.module.dto.product.ProductSearchRQ;
import com.viranga.shoppingcart.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getAvailableProducts", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseDTO<AvailableProductSearchRS> getAvailableProducts(@RequestBody ProductSearchRQ searchRQ) {

        LOG.info("START :Get available products : {}", searchRQ);
        AvailableProductSearchRS response = this.productService.getAvailableProducts(searchRQ);
        LOG.info("END :Get available products : {}", searchRQ);
        return new ResponseDTO<>(response);
    }

}
