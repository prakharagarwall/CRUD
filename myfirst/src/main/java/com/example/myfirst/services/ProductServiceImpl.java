package com.example.myfirst.services;

import com.example.myfirst.domain.product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by jt on 11/6/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer,product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public List<product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public product getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public product saveOrUpdateProduct(product product) {
        if (product != null) {
            if (product.getId() == null) {
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);

            return product;
        } else {
            throw new RuntimeException("Product Can't be nill");
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet()) + 1;
    }



    private void loadProducts(){
        products = new HashMap<>();

        product product1 = new product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        products.put(1, product1);

        product product2 = new product();
        product2.setId(2);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        products.put(2, product2);

        product product3 = new product();
        product3.setId(3);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        products.put(3, product3);

        product product4 = new product();
        product4.setId(4);
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        products.put(4, product4);

        product product5 = new product();
        product5.setId(5);
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        products.put(5, product5);
    }
}