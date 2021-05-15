package com.stock.fantasy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stock.fantasy.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p.pname,p.price,p.stock from Product p")
	List<Object []> getProductsfilter();
	
	
	List<Product> findByIdAndCategoryId(int id,int categoryId);
}
