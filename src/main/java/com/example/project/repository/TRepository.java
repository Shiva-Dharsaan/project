package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Pricedata1;
import com.example.project.model.THistory;

//This indicates that it will be used to manage entities of type THistory with integer primary keys.

public interface TRepository extends JpaRepository<THistory,Integer>{
	// This is a custom query method declared within the interface. It specifies a query to retrieve a list of THistory entities based on the investor attribute.

	List<THistory> findByInvestorid(String investor);

}