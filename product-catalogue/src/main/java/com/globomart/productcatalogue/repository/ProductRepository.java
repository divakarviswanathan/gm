package com.globomart.productcatalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globomart.productcatalogue.entity.Product;

/**
 * @author divakar
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByType(String type);

	List<Product> findByManufacturer(String manufacturer);
}
