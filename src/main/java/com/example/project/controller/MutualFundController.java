package com.example.project.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.repository.MutualFundRepository;
import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.MutualFundModel;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MutualFundController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	{
		BasicConfigurator.configure();
	}
	
	@Autowired
	public MutualFundRepository mfRepo;
	
	@PostMapping("/CreateMf")
	public MutualFundModel addmutualfund(@RequestBody MutualFundModel mf)
	
	{
		log.info("Mutual Fund created Sucessfully :)");
		Random rand = new Random();
		   
        // Generate random integers in range 0 to 999
        int mf_id = rand.nextInt(10000);
        
		try{
			//log.info(mf_id);
			mfRepo.insertMf(mf_id,mf.getName_of_mf(),mf.getEntry_load(),mf.getExit_load(),mf.getExpense_ratio(),mf.getBalance_cash(),mf.getNav(),mf.getTotal_corpus(),mf.getCreated_by());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

        return mf;
	}
	@GetMapping("/allMutualFunds")
	public List<MutualFundModel> getAllMutualFunds()
	{
		return mfRepo.findAll();
	}
	@GetMapping("/findMutualFund/{mid}")
	public MutualFundModel getMutualFund(@PathVariable("mid")  int mid)
	{
		return mfRepo.findById(mid).get();
	}
   	@GetMapping("/postmf/totalcorpus/{mid}")
	public double seeTotalCorpus(@PathVariable("mid")  int mid)
	{
		Optional<MutualFundModel> mf=mfRepo.findById(mid);
		
		if(mf.isPresent())
		{
			MutualFundModel mf1=mf.get();
			log.info("Getting total corpus for this mutual fund");
			return mf1.getTotal_corpus();
		}
		else
		{
			log.warn("No mutual fund with id "+mid);
			throw new CustomExceptionMessage("No such mutual fund found");
			//return 0.0;
		}
	}
	@PutMapping("/updateTotalCorpus/{totalCorpus}/{modifiedBy}/{mfid}")
	public MutualFundModel updateTotalCorpus(@PathVariable("totalCorpus")  double totalCorpus,@PathVariable("modifiedBy")  String modifiedBy,@PathVariable("mfid") int mfid)
	{
		mfRepo.updateTotalCorpus(totalCorpus, modifiedBy, mfid);
		
		return mfRepo.findById(mfid).get();
	}
	
	@PutMapping("/updateTotalCorpus/{weightage}/{mfid}")
	public MutualFundModel updateWeightage(@PathVariable("weightage")  int weightage,@PathVariable("mfid") int mfid)
	{
		mfRepo.updateWeightage(weightage,mfid);
		
		return mfRepo.findById(mfid).get();
	}

	
	@DeleteMapping("/delete a Mf/{mid}")
	public String deleteMutualFund(@PathVariable("mid")  int mid)
	{
		mfRepo.deleteById(mid);;
		
		return "Mutual fund with id "+mid+" has been deleted";
	}

}
