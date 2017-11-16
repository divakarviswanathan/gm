package com.globomart.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.productcatalogue.entity.Product;
import com.globomart.productcatalogue.repository.ProductRepository;
import com.globomart.productcatalogue.service.ProductService;

/**
 * @author divakar
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
		productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByType(String type) {
        return productRepository.findByType(type);
    }

    @Override
    public void removeProduct(long id) {
        productRepository.delete(id);
    }

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) throws Exception {
		return productRepository.findByManufacturer(manufacturer);
	}
}
