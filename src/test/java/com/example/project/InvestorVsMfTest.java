package com.example.project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project.model.InvestorVsMf;
import com.example.project.repository.InvestorVsMfRepository;

@SpringBootTest
public class InvestorVsMfTest {
	
	
	@Autowired
	InvestorVsMfRepository lRepo;
	//case 1: validate units owned by investor in a particular mutual fund 
	
	@Test
	public void testUnit()
	{	InvestorVsMf l1=lRepo.findById(2000).get();
		assertAll("unit",
			() -> assertNotEquals(10,l1.getNoofunits(),"Unit is incorrect"),
			() -> assertEquals("Muthoot",l1.getNameofmf(),"name is incorrect")
			);
		InvestorVsMf l2=lRepo.findById(1).get();
		assertAll("unit",
			() -> assertNotEquals(10,l2.getNoofunits(),"Unit is incorrect"),
			() -> assertEquals("Muthoot",l2.getNameofmf(),"name is incorrect")
			);
		
	}
	
	@Test
	public void testAmount()
	{
		InvestorVsMf l1=lRepo.findById(2000).get();
		assertAll("unit",
			() -> assertNotEquals(9900,l1.getAmount(),"Unit is incorrect"),
			() -> assertEquals("Muthoot",l1.getNameofmf(),"name is incorrect")
			);
		InvestorVsMf l2=lRepo.findById(1).get();
		assertAll("unit",
			() -> assertNotEquals(11.828,l2.getAmount(),"Unit is incorrect"),
			() -> assertEquals("Muthoot",l2.getNameofmf(),"name is incorrect")
			);
	}
}