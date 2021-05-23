package com.viranga.shoppingcart.service.basket.support;

import com.viranga.shoppingcart.dao.ProductDao;
import com.viranga.shoppingcart.module.dto.BasketCalculateRQ;
import com.viranga.shoppingcart.module.dto.BasketCalculateRS;
import com.viranga.shoppingcart.module.dto.BasketItemDTO;
import com.viranga.shoppingcart.module.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasketPriceBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(BasketPriceBuilder.class);

    private BasketCalculateRQ basketCalculateRQ;

    private BasketCalculateRS basketCalculateRs;

    private ProductDao productDao;

    private Map<Integer, ProductDTO> idWiseproducts;

    public BasketPriceBuilder(BasketCalculateRQ basketCalculateRQ) {
        this.basketCalculateRQ = basketCalculateRQ;
        basketCalculateRs = new BasketCalculateRS();
    }

    public BasketPriceBuilder setProductDao(ProductDao productDao) {
        this.productDao = productDao;
        return this;
    }

    public BasketPriceBuilder loadProducts() {
        List<Integer> productIDs = basketCalculateRQ.getBasketItemList().stream()
                .map(BasketItemDTO::getProductID)
                .collect(Collectors.toList());

        idWiseproducts = productDao.getIdWiseProductsByProductIDs(productIDs);
        LOG.info("END: Product list loaded: productIDs:{}, ", productIDs);
        return this;
    }

    public BasketPriceBuilder calculateItemWisePrice() {
        basketCalculateRQ.getBasketItemList().forEach(basketItemDTO -> {
            ProductDTO productDTO = idWiseproducts.get(basketItemDTO.getProductID());

            PriceCalculator calculator = new PriceCalculator(productDTO, basketItemDTO);
            calculator.calculate();
            BasketItemDTO calculatedBasket = calculator.getBasketItemDTO();

            basketCalculateRs.addBasketItemDTO(calculatedBasket);
            basketCalculateRs.addTotalBasketAmount(basketItemDTO.getPrice());
            basketCalculateRs.addTotalDiscountAmount(basketItemDTO.getDiscount());
            basketCalculateRs.addTotalNetAmount(basketItemDTO.getNetPrice());
        });

        LOG.info("END: Basket price calculated :{}, ", basketCalculateRs);
        return this;
    }

    public BasketCalculateRS getBasketCalculateRs() {
        return basketCalculateRs;
    }
}
