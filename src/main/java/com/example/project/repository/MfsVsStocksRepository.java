package com.example.project.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.project.model.MutualFundsVsStocks;

//This indicates that it will be used to manage entities of type MutualFundsVsStocks with integer primary keys.

public interface MfsVsStocksRepository extends  JpaRepository<MutualFundsVsStocks,Integer>{
	List<MutualFundsVsStocks> findByMfid(int mfid);
	
	@Procedure(procedureName="SHIVA.INSERTMFWEIGHTAGE")
	
	void insertMfWeightage(
			@Param("pId")
			int pid,
			@Param("currentDate")
			String currdate,
	        @Param("mfId")
			int mfid,
			@Param("nameOfStock")
			String nameofstocks,
			@Param("noOfUnits")
			double noofunits,
			@Param("weightage")
			int weightage,
			@Param("created_by")
			String created_by);
	
	
}
