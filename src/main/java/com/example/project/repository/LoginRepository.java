package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.project.model.Login;
//The LoginRepository is a Spring component and should be automatically scanned and registered as a Spring Bean.
	
	@Component
	// This indicates that it will be used to manage entities of type Login with a primary key of type String.

	public interface LoginRepository extends JpaRepository<Login,String> {
		
		@Procedure(procedureName="SHIVA.INSERTlOGIN")
		void insertLogin(
		@Param("loginid")
		String loginid,
		@Param("password")
		String password,
		@Param("typeofuser")
		String typeofuser,
		@Param("created_by")
		String created_by);
	}
	
	