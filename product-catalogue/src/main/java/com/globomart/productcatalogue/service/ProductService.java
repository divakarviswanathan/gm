package com.globomart.productcatalogue.service;

import java.util.List;

import com.globomart.productcatalogue.entity.Product;

/**
 * @author divakar
 *
 */
public interface ProductService {

    void addProduct(Product product) throws Exception;

    List<Product> getAllProducts() throws Exception;

    List<Product> getProductsByType(String type) throws Exception;

	List<Product> getProductsByManufacturer(String manufacturer) throws Exception;

    void removeProduct(long id) throws Exception;
}
