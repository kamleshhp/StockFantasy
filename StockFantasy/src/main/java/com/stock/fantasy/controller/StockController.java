package com.stock.fantasy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.stock.fantasy.entity.Product;
import com.stock.fantasy.entity.User;
import com.stock.fantasy.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService service;

	@PostMapping("/save")
	public ResponseEntity<User> save2(@RequestBody User u) {

		User u1 = null;

		try {
			u1 = this.service.save1(u);

			return ResponseEntity.status(HttpStatus.CREATED).body(u);
		}

		catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/filterdata")
	public ResponseEntity<List<Object[]>> getProductDetailsByFilter() {

		List<Object[]> list = this.service.getDetails();

		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));

	}

	@GetMapping("/GetAllProducts")
	public ResponseEntity<List<Product>> getAll() {

		List<Product> list = this.service.getAllProducts();

		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));

	}

	@GetMapping("/GetAllUsersAssociatedProduct")
	public ResponseEntity<List<User>> getAll1() {

		List<User> list = this.service.getAllUser();

		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));

	}
    
	@GetMapping("/GetSpecific/{id}/{categoryId}")
	public ResponseEntity<List<Product>> getSpecifDetails(@PathVariable("id") int id,@PathVariable("categoryId") int categoryId) {

		List<Product> list = this.service.getAllProducts();

		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));

	}
	
	@GetMapping("/Join")
	public ResponseEntity<List<Object[]>> getJoin(){

		List<Object[]> list = this.service.getResult();

		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));

	}
	
	@PostMapping("/save1")
	public ResponseEntity<Product> save3(@RequestBody Product u) {

		Product u1 = null;

		try {
			u1 = this.service.saveProduct(u);

			return ResponseEntity.status(HttpStatus.CREATED).body(u);
		}

		catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@PostMapping("/DeleteAll")
	public ResponseEntity<?> deleteUserByProduct(@RequestBody User u) {
        try {
		this.service.deleteUserProduct(u);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e) {
        	
        	e.printStackTrace();
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

	}
	
	@GetMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteUserByIdUserProduct(@PathVariable("id") int id) {
        try {
		this.service.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e) {
        	
        	e.printStackTrace();
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

	}
	
	
	@GetMapping("/deleteById1/{id1}")
	public ResponseEntity<?> deleteUserByIdProduct(@PathVariable("id") int id) {
        try {
		this.service.deleteProductById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e) {
        	
        	e.printStackTrace();
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

	}
	
	
	
	@PutMapping("/UserDe/{id}")
	public ResponseEntity<User> updateBook(@RequestBody User user, @PathVariable("id") int id) {

		try {

			this.service.UpdateDetails(user, id);
			
			return ResponseEntity.ok().body(user);
			
			

		}

		catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	
	
	
	
	
	


}
