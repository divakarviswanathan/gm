package com.globomart.productcatalogue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.productcatalogue.entity.Product;
import com.globomart.productcatalogue.service.ProductService;

/**
 * @author divakar
 *
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public void addNewProduct(@RequestBody Product product) {
		logger.info("Entering add products");
        try {
            productService.addProduct(product);
        } catch (Exception e) {
            logger.error("Error occurred while adding new product", e);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
		logger.info("Entering get all products");
        try {
            return productService.getAllProducts();
        } catch (Exception e) {
            logger.error("Error occurred while getting all products", e);
        }
        return null;
    }

	@RequestMapping(value = "/searchByType", method = RequestMethod.GET)
	public List<Product> getProductsByType(@RequestParam(value = "type", required = true) final String type) {
		logger.info("Entering get products by type");
		try {
			return productService.getProductsByType(type);
		} catch (Exception e) {
			logger.error("Error occurred while getting products by type", e);
		}
		return null;
	}

	@RequestMapping(value = "/searchByManu", method = RequestMethod.GET)
	public List<Product> getProductsByManufacturer(
			@RequestParam(value = "manu", required = true) final String manufacturer) {
		logger.info("Entering get products by type");
		try {
			return productService.getProductsByManufacturer(manufacturer);
		} catch (Exception e) {
			logger.error("Error occurred while getting products by manufacturer", e);
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") long id) {
		logger.info("Entering delete products");
        try {
            productService.removeProduct(id);
        } catch (Exception e) {
            logger.error("Error occurred while deleting a product", e);
        }
    }
}
