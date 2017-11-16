package com.globomart.productcatalogue.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.productcatalogue.entity.Product;
import com.globomart.productcatalogue.repository.ProductRepository;
import com.globomart.productcatalogue.rest.entity.ProductDTO;
import com.globomart.productcatalogue.service.ProductService;
import com.globomart.productcatalogue.util.ObjectConverterUtil;

/**
 * @author divakar
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

	@Autowired
	private ObjectConverterUtil objectConverterUtil;

    @Override
	public void addProduct(Product product) throws Exception {
		productRepository.save(product);
    }

    @Override
	public List<ProductDTO> getAllProducts() throws Exception {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		if (products != null && products.size() > 0) {
			for (Product product : products) {
				productDTOs.add(objectConverterUtil.domainToDTOObject(product));
			}
		}
		return productDTOs;
    }

    @Override
	public List<ProductDTO> getProductsByType(String type) throws Exception {
		List<Product> products = productRepository.findByType(type);
		List<ProductDTO> productDTOs = new ArrayList<>();
		if (products != null && products.size() > 0) {
			for (Product product : products) {
				productDTOs.add(objectConverterUtil.domainToDTOObject(product));
			}
		}
		return productDTOs;
    }

    @Override
	public void removeProduct(long id) throws Exception {
        productRepository.delete(id);
    }

	@Override
	public List<ProductDTO> getProductsByManufacturer(String manufacturer) throws Exception {
		List<Product> products = productRepository.findByManufacturer(manufacturer);
		List<ProductDTO> productDTOs = new ArrayList<>();
		if (products != null && products.size() > 0) {
			for (Product product : products) {
				productDTOs.add(objectConverterUtil.domainToDTOObject(product));
			}
		}
		return productDTOs;
	}
}
