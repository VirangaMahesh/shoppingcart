package com.viranga.shoppingcart.dao;

import com.viranga.shoppingcart.module.dto.ProductDTO;
import com.viranga.shoppingcart.module.dto.product.ProductSearchRQ;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDao {

    public static List<ProductDTO> productDTOList = new ArrayList<>();

    public static List<ProductDTO> getProducts() {
        if (productDTOList.isEmpty()) {
            productDTOList.add(new ProductDTO(1, "0000001", "Panadol", 144L, 144.00));
            productDTOList.add(new ProductDTO(2, "0000002", "Amoxicillin", 100L, 2300.00));
            productDTOList.add(new ProductDTO(3, "0000003", "Ascorbic acid 100ml", 1000L, 900.00));
            productDTOList.add(new ProductDTO(4, "0000004", "Rapisol 500 mg", 120L, 240.00));
            productDTOList.add(new ProductDTO(5, "0000005", "Kalzana 500 mg", 100L, 2500.00));
            productDTOList.add(new ProductDTO(6, "0000006", "Surgical mask", 100L, 1000.00));
            productDTOList.add(new ProductDTO(7, "0000007", "HansSanitiser", 100L, 300.00));
            productDTOList.add(new ProductDTO(8, "0000008", "Candid B", 10L, 5000.00));
            productDTOList.add(new ProductDTO(9, "0000009", "Panadine", 5L, 30.00));
            productDTOList.add(new ProductDTO(10, "0000010", "Disprine", 10L, 30.00));
            productDTOList.add(new ProductDTO(11, "0000011", "Citrazine", 12L, 60.00));
            productDTOList.add(new ProductDTO(12, "0000012", "Piriton", 15L, 60.00));
            productDTOList.add(new ProductDTO(13, "0000013", "Asprine", 6L, 60.00));
            productDTOList.add(new ProductDTO(14, "0000014", "Insulin", 4L, 100.00));
            productDTOList.add(new ProductDTO(15, "0000015", "Baclofine", 10L, 200.00));
            productDTOList.add(new ProductDTO(16, "0000016", "Isopropile 500ml", 12L, 4000.00));
            productDTOList.add(new ProductDTO(17, "0000017", "Sanitizer Spray", 20L, 6000.00));
            productDTOList.add(new ProductDTO(18, "0000018", "Dettol 100ml", 20L, 7000.00));
//            productDTOList.add(new ProductDTO(19, "0000019", "Dog Collar", 9.0, 300.00));
//            productDTOList.add(new ProductDTO(20, "0000020", "Dog Collar", 50.0, 300.00));
//            productDTOList.add(new ProductDTO(21, "0000021", "Dog Collar", 25.0, 300.00));
//            productDTOList.add(new ProductDTO(22, "0000022", "Dog Collar", 5.0, 300.00));
//            productDTOList.add(new ProductDTO(23, "0000023", "Dog Collar", 5.0, 300.00));
//            productDTOList.add(new ProductDTO(24, "0000024", "Dog Collar", 5.0, 300.00));
//            productDTOList.add(new ProductDTO(25, "0000025", "Dog Collar", 5.0, 300.00));
//            productDTOList.add(new ProductDTO(26, "0000026", "Dog Collar", 5.0, 300.00));
//            productDTOList.add(new ProductDTO(27, "0000027", "Dog Collar", 5.0, 300.00));
//            productDTOList.add(new ProductDTO(28, "0000028", "Dog Collar", 5.0, 300.00));
//            productDTOList.add(new ProductDTO(29, "0000029", "Dog Collar", 5.0, 300.00));
        }
        return productDTOList;
    }


    public List<ProductDTO> getAvailableProducts(ProductSearchRQ searchRQ) {

        List<ProductDTO> filteredProductList = new ArrayList<>();
        List<ProductDTO> productDTOList = ProductDao.getProducts();
        productDTOList.forEach(productDTO -> {
            if (productDTO != null) {
                if (StringUtils.isBlank(searchRQ.getSearchKeyWord())) {
                    filteredProductList.add(new ProductDTO(productDTO));
                } else if (productDTO.getProductName().contains(searchRQ.getSearchKeyWord()) || productDTO.getProductCode().contains(searchRQ.getSearchKeyWord())) {
                    filteredProductList.add(new ProductDTO(productDTO));
                }
            }

        });

        return filteredProductList;
    }

    public List<ProductDTO> getProductsByProductIDs(List<Integer> productIDs) {

        List<ProductDTO> filteredProductList = new ArrayList<>();
        List<ProductDTO> productDTOList = ProductDao.getProducts();

        productDTOList.forEach(productDTO -> {
            if (productIDs.contains(productDTO.getProductID())) {
                filteredProductList.add(new ProductDTO(productDTO));
            }

        });

        return filteredProductList;
    }

    public Map<Integer, ProductDTO> getIdWiseProductsByProductIDs(List<Integer> productIDs) {

        Map<Integer, ProductDTO> idWiseProducts = new HashMap<>();
        List<ProductDTO> productDTOList = ProductDao.getProducts();

        productDTOList.forEach(productDTO -> {
            if (productIDs.contains(productDTO.getProductID())) {
                idWiseProducts.put(productDTO.getProductID(), new ProductDTO(productDTO));
            }

        });

        return idWiseProducts;
    }
}
