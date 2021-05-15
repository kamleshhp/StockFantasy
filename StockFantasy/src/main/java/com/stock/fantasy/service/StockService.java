package com.stock.fantasy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.fantasy.dao.ProductRepository;
import com.stock.fantasy.dao.UserRepository;
import com.stock.fantasy.entity.Product;
import com.stock.fantasy.entity.User;

@Service
public class StockService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public User save1(User u) {
		
		return this.userRepository.save(u);
		
		
		
		
	}
	
	
	public List<Object []> getDetails(){
		
		return this.productRepository.getProductsfilter();
	}
	
	public List<Product> getAllProducts(){
		
		return this.productRepository.findAll();
	}
	
	
	public List<User> getAllUser(){
		
		return this.userRepository.findAll();
	}
	
	public List<Product> getspecific(int id,int categoryId){
		return this.productRepository.findByIdAndCategoryId(id, categoryId);
	}
	
	public List<Object []> getResult(){
		
		return this.userRepository.getCombined();
	}
	
	public Product saveProduct(Product p) {
		return this.productRepository.save(p);
	}
	
	public void deleteUserProduct(User u) {
		
		this.userRepository.delete(u);
	}
	
	public void deleteById(int id) {
		this.userRepository.deleteById(id);
	}
	
	//similary we can create for indiviual product also
	
	
	public void deleteProductById(int id) {
		this.productRepository.deleteById(id);
	}
	
	
	public void UpdateDetails(User u,int id) {
		
		u.setId(id);
		
		this.userRepository.save(u);
		
	}

}
