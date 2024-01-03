package com.example.project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.project.model.Pricedata1;
//@Component, indicating that it should be automatically registered as a Spring Bean

@Component
//This indicates that it will be used to manage entities of type Pricedata1 with integer primary keys.


public interface Pricedata1Repository extends JpaRepository<Pricedata1,Integer> {
	//@Autowired
	// This is a custom query method declared within the interface. It specifies a query to retrieve a list of Pricedata1 entities based on the name_of_share attribute.

	List<Pricedata1> findByNameofshare(String name_of_share);
	
	List<Pricedata1> findByClosingdate(String name_of_share);
	
	
}
