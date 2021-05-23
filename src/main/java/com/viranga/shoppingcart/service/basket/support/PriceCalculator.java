package com.viranga.shoppingcart.service.basket.support;

import com.viranga.shoppingcart.commons.SystemParameter;
import com.viranga.shoppingcart.module.dto.BasketItemDTO;
import com.viranga.shoppingcart.module.dto.ProductDTO;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PriceCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(PriceCalculator.class);

    private ProductDTO productDTO;

    private BasketItemDTO basketItemDTO;

    public PriceCalculator(ProductDTO productDTO, BasketItemDTO basketItemDTO) {
        this.productDTO = productDTO;
        this.basketItemDTO = basketItemDTO;
    }

    public void calculate() {
        Pair<Long, Long> cartonUnitQty = CalculatorUtil.calculateCartonQtyAndUnitQty(basketItemDTO.getPurchaseQuantity(), productDTO.getCartonSize());

        Double totalUnitAmount = this.calculateUnitTotalPrice(cartonUnitQty.getRight(), productDTO.getCartonPrice(), productDTO.getCartonSize());
        Double totalCartonAmount = this.calculateCartonTotalPrice(cartonUnitQty.getLeft(), productDTO.getCartonPrice());
        Double discountedCartonPrice = this.calculateDiscountedCartonPrice(cartonUnitQty.getLeft(), productDTO.getCartonPrice());
        Double totalDiscountedUnitAmount = this.calculateUnitTotalPrice(cartonUnitQty.getRight(), discountedCartonPrice, productDTO.getCartonSize());
        Double totalDiscountedCartonAmount = this.calculateCartonTotalPrice(cartonUnitQty.getLeft(), discountedCartonPrice);

        basketItemDTO.setPrice(CalculatorUtil.round(totalUnitAmount + totalCartonAmount));
        basketItemDTO.setNetPrice(CalculatorUtil.round(totalDiscountedUnitAmount + totalDiscountedCartonAmount));
        basketItemDTO.setDiscount(basketItemDTO.getPrice() - basketItemDTO.getNetPrice());
        LOG.info("Product price calculated: {}", basketItemDTO);
    }

    public BasketItemDTO getBasketItemDTO() {
        return basketItemDTO;
    }

    private Double calculateUnitTotalPrice(Long unitQty, Double cartonPrice, Long cartonSize) {
        double totalUnitPrice = 0.0;
        if (unitQty != 0) {
            Double unitMargin = SystemParameter.getPerUnitMargin();
            Double perUnitPrice = ((cartonPrice / cartonSize) * (100 + unitMargin)) / 100;

            totalUnitPrice = perUnitPrice * unitQty;
        }
        return totalUnitPrice;
    }


    private Double calculateDiscountedCartonPrice(Long cartonQty, Double cartonPrice) {
        if (cartonQty >= SystemParameter.getCartonDiscountQty()) {
            Double discountedAmount = (cartonPrice * SystemParameter.getCartonDiscountPercentage()) / 100;
            cartonPrice = cartonPrice - discountedAmount;

        }
        return cartonPrice;
    }

    private Double calculateCartonTotalPrice(Long cartonQty, Double discountedCartonPrice) {
        double totalUnitPrice = 0.0;
        if (cartonQty != 0) {

            totalUnitPrice = discountedCartonPrice * cartonQty;
        }
        return totalUnitPrice;
    }
}
