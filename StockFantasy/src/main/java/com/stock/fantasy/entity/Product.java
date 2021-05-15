package com.stock.fantasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String  pname;
	
	@Column
	private int stock;
	
	@Column
	private int price;
	
	@Column
	private int categoryId;
	
	
	

	public Product() {
		
	}




	public Product(int id, String pname, int stock, int price, int categoryId) {
		this.id = id;
		this.pname = pname;
		this.stock = stock;
		this.price = price;
		this.categoryId = categoryId;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getPname() {
		return pname;
	}




	public void setPname(String pname) {
		this.pname = pname;
	}




	public int getStock() {
		return stock;
	}




	public void setStock(int stock) {
		this.stock = stock;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", stock=" + stock + ", price=" + price + ", categoryId="
				+ categoryId + "]";
	}
	
	

}