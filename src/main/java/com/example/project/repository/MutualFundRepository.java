package com.example.project.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.project.model.MutualFundModel;

//@Component annotation indicates that the MutualFundRepository is a Spring component and should be automatically scanned and registered as a Spring Bean.

@Component
//This indicates that it will be used to manage entities of type MutualFundModel with integer primary keys.

public interface MutualFundRepository extends JpaRepository<MutualFundModel,Integer> {
	//List<MutualFundModel> findByNav();
	@Procedure(procedureName="SHIVA.INSERTMF")

    void insertMf(

    @Param("mfid")

    int mfid,

    @Param("nameofmf")

    String nameofmf,

    @Param("entryload")

    int entryload,

    @Param("exitload")

    int exitload,

    @Param("expenseratio")

    int expenseratio,

    @Param("balancecash")

    double balancecash,

    @Param("nav")

    double nav,

    @Param("totalcorpus")

    double totalcorpus,
    
    @Param("created_by")
    
    String created_by
    );
	
	@Procedure(procedureName="UPDATETOTALCORPUS")
	
	void updateTotalCorpus(

		    @Param("totalCorpus")

		    double totalcorpus,
			            
            @Param("modifiedBy")
		    
		    String modified_by,
		    
		    @Param("mfId")

		    int mfid

			);
	
@Procedure(name=MutualFundModel.updateWeightage) 
	
	void updateWeightage(

		    @Param("weightage")

		    int available_weightage,
			      
		    
		    @Param("mfid")

		    int mfid

			);
}