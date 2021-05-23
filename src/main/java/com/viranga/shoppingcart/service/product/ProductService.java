package com.viranga.shoppingcart.service.product;

import com.viranga.shoppingcart.dao.ProductDao;
import com.viranga.shoppingcart.module.dto.ProductDTO;
import com.viranga.shoppingcart.module.dto.product.AvailableProductSearchRS;
import com.viranga.shoppingcart.module.dto.product.ProductSearchRQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductDao productDao;


    @Transactional(propagation = Propagation.SUPPORTS)
    public AvailableProductSearchRS getAvailableProducts(ProductSearchRQ searchRQ) {
        AvailableProductSearchRS result = new AvailableProductSearchRS();
        LOG.info("START :Get available products : {}", searchRQ);

        List<ProductDTO> productDTOList = this.productDao.getAvailableProducts(searchRQ);
        result.setProducts(productDTOList);
        LOG.info("END :Get available products : {}", searchRQ);

        return result;
    }

}
