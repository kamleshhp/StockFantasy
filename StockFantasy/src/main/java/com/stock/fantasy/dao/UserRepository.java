package com.stock.fantasy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stock.fantasy.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	
	@Query("select u.id,p.categoryId from User u inner join u.products as p")
	List<Object []> getCombined();
	
	

}
