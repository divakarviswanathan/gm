package com.globomart.productcatalogue.service;

import java.util.List;

import com.globomart.productcatalogue.entity.Product;
import com.globomart.productcatalogue.rest.entity.ProductDTO;

/**
 * @author divakar
 *
 */
public interface ProductService {

    void addProduct(Product product) throws Exception;

	List<ProductDTO> getAllProducts() throws Exception;

	List<ProductDTO> getProductsByType(String type) throws Exception;

	List<ProductDTO> getProductsByManufacturer(String manufacturer) throws Exception;

    void removeProduct(long id) throws Exception;
}
