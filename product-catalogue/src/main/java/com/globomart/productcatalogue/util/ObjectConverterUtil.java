package com.globomart.productcatalogue.util;

import org.springframework.stereotype.Component;

import com.globomart.productcatalogue.entity.Product;
import com.globomart.productcatalogue.rest.entity.ProductDTO;

/**
 * @author divakar
 *
 */
@Component
public class ObjectConverterUtil {

	/**
	 * @param productDTO
	 * @return
	 * method converts the transfer object to domain entity
	 */
	public Product dtoToDomainObject(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setManufacturer(productDTO.getManufacturer());
		product.setType(productDTO.getType());
		return product;
	}

	/**
	 * @param product
	 * @return
	 * method converts the domain entity to transfer object
	 */
	public ProductDTO domainToDTOObject(Product product) {
		ProductDTO pto = new ProductDTO();
		pto.setId(product.getId());
		pto.setName(product.getName());
		pto.setDescription(product.getDescription());
		pto.setManufacturer(product.getManufacturer());
		pto.setType(product.getType());
		return pto;
	}
}
