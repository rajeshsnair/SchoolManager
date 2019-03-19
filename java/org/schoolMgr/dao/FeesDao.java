package org.schoolMgr.dao;



import java.util.ArrayList;





import org.schoolMgr.model.FeeInfo;
import org.schoolMgr.model.FeeTypeForm;







public interface FeesDao {


	 public ArrayList<FeeInfo> listAnnualFees();
	 
	 public boolean saveFees(FeeInfo fee);
	 
	 public boolean saveFeeType(FeeTypeForm feetype);

	
}
