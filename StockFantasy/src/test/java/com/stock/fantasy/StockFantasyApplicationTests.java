package com.stock.fantasy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.stock.fantasy.dao.ProductRepository;
import com.stock.fantasy.entity.Product;
import com.stock.fantasy.service.StockService;



@SpringBootTest
class StockFantasyApplicationTests {
	@RunWith(SpringRunner.class)
	@SpringBootTest
	class SpringBootCrudApplicationTests {
	    
		@Autowired
		private StockService service;
		
		@MockBean
		private ProductRepository repository;
		
		@Test
		public void getProductsTest() {
			when(repository.findAll()).thenReturn(Stream.of(new Product(201,"Ps2", 22, 7000, 3),new Product(202,"Ps3", 22, 7000, 3)).collect(Collectors.toList()));
			
			assertEquals(2,service.getAllProducts().size());
		}
		
		
		
		@Test
		public void saveProductTest() {
			Product product=new Product(201,"Ps2", 22, 7000, 3);
			
			when(repository.save(product)).thenReturn(product);
			
			assertEquals(product,service.saveProduct(product));
		}
		
		
		@Test
		public void deleteProduct() {
			
			Product p=new Product(201,"Ps2", 22, 7000, 3);
			
			service.deleteProductById(p.getId());
			
			verify(repository,times(1)).deleteById(p.getId());
			
			

		}


	}
}
