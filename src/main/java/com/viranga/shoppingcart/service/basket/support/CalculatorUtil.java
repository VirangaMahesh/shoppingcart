package com.viranga.shoppingcart.service.basket.support;

import com.viranga.shoppingcart.commons.SystemParameter;
import org.apache.commons.lang3.tuple.Pair;

public class CalculatorUtil {


    public static Pair<Long, Long> calculateCartonQtyAndUnitQty(Long requestedQty, Long cartonSize) {
        Pair<Long, Long> result = null;

        if (requestedQty < cartonSize) {
            result = Pair.of(0L, requestedQty);
        } else {
            Long unitQty = requestedQty % cartonSize;
            Long cartonQty = requestedQty / cartonSize;
            result = Pair.of(cartonQty, unitQty);
        }
        return result;

    }

    public static Double round(Double amount) {
        return Math.round(amount * 100) / 100.00;

    }


    public static Double perUnitPrice(Double cartonPrice, Long cartonSize) {
        Double perUnitPrice = (cartonPrice / cartonSize) * (100 + SystemParameter.getPerUnitMargin()) / 100;
        return CalculatorUtil.round(perUnitPrice);
    }
}
