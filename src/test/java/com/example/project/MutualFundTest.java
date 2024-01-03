//package com.example.project;
//
////import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//import com.example.project.model.MutualFundModel;
//import com.example.project.repository.MutualFundRepository;
////import com.google.common.base.Optional;
//import java.util.Optional;
//
//public class MutualFundTest {
//	
//	@Autowired
//	public MutualFundRepository mfRepo;
//	
//	@Test
//	void TotalCorpusCheck()
//	{
//		Optional<MutualFundModel> mfOptional = mfRepo.findById(2);
//	    assertTrue(mfOptional.isPresent(), "Mutual Fund with ID 2 not found");
//	    MutualFundModel m = mfOptional.get();
//	    int total_corpus = m.getEntry_load();
//	    assertEquals(1, total_corpus, "Entry load is not equal to 1");
//	}
//
//}
package com.example.project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project.controller.LoginController;
import com.example.project.controller.MutualFundController;
import com.example.project.model.Login;
import com.example.project.model.MutualFundModel;
import com.example.project.repository.LoginRepository;
import com.example.project.repository.MutualFundRepository;

@SpringBootTest
public class MutualFundTest {

	 	@Autowired
		MutualFundRepository mRepo;
	 	
	 	//Case 1: We are writing the testcode to add MutualFund 
		@Test
		public void AddValidMfTest()
		{	
			MutualFundModel mf = new MutualFundModel();
			mf.setMf_id(12);
			mf.setName_of_mf("L&T");
			mf.setEntry_load(20);
			mf.setExit_load(20);
			mf.setExpense_ratio(25);
			mf.setBalance_cash(15000);
			mf.setNav(45);
			mf.setTotal_corpus(15000);
			mRepo.save(mf);
			assertNotNull(mRepo.findById(12).get());
	   }
			
		//Case 2: We are validating total_corpus by passing mutualfund_id
		@Test
		public void validTotalCorpus()
		{	
			MutualFundModel mf=mRepo.findById(7).get();
			double totalCorpus=mf.getTotal_corpus();
			assertEquals(700000000,totalCorpus);
		
		
		}
		
		//Case 3: we are validating whether the mutualfund is found or not by passing invalid mutual_fund_id
        @Test
        public void validateMFTest()
        {
        	int nonuser=19;
        	Optional<MutualFundModel> mf=mRepo.findById(nonuser);
        	MutualFundModel mf1;
        	if(mf.isPresent())
        	{
        		mf1=mf.get();
        		assertNull(mf1);
        	}
        	else
        	{
        		mf1=null;
        		assertNull(mf1);
        	}
        	
        }
        
        //case 4:valdiate name
        @Test
        public void testName()
        {
        	MutualFundModel l1=mRepo.findById(1).get();
        	MutualFundModel l2=mRepo.findById(2).get();
        	MutualFundModel l3=mRepo.findById(7).get();
        	assertAll("NameCheck",
        			
        			() -> assertEquals("Muthoot",l1.getName_of_mf(),"name is correct "),
        			()-> assertEquals("Moon",l2.getName_of_mf(),"name is correct "),
        			()-> assertEquals("welcome",l3.getName_of_mf(),"name is correct "));
        	
        }
        
        
     

		
}
