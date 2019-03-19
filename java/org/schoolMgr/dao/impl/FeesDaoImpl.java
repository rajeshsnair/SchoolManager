/**
 * 
 */
package org.schoolMgr.dao.impl;


import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.schoolMgr.dao.FeesDao;
import org.schoolMgr.entity.Fees;
import org.schoolMgr.entity.FeesType;

import org.schoolMgr.model.FeeInfo;
import org.schoolMgr.model.FeeTypeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author narajesh
 *
 */

//Transactional for Hibernate
@Transactional
public class FeesDaoImpl implements FeesDao{

	 @Autowired
	 private SessionFactory sessionFactory;

	

	@Override
	public ArrayList<FeeInfo> listAnnualFees() {
		
	Session session = sessionFactory.getCurrentSession();
	ArrayList<Fees> feeList =	(ArrayList<Fees>) session.createCriteria(Fees.class).
			list();
	
	ArrayList<FeesType> feeTypeList =	(ArrayList<FeesType>) session.createCriteria(FeesType.class).
			add(Restrictions.eq("fee_type", "A")).list();
	
	ArrayList<FeeInfo> feesList = new ArrayList<FeeInfo>();
	ArrayList<FeeTypeForm> feetypes = new ArrayList<FeeTypeForm>();
	
	if(!feeTypeList.isEmpty()|| feeTypeList!=null){
	for (FeesType feeType : feeTypeList){
		FeeTypeForm feetype = new FeeTypeForm();
		feetype.setFee_name(feeType.getFee_name());
		
	    feetype.setLkg_value(feeType.getLkg_value());
	    feetype.setUkg_value(feeType.getLkg_value());
	    feetype.setFirst_value(feeType.getFirst_value());
	    feetype.setSecond_value(feeType.getSecond_value());
	    feetype.setThird_value(feeType.getThird_value());
	    feetype.setFourth_value(feeType.getFourth_value());
	    feetype.setFifth_value(feeType.getFifth_value());
	    feetype.setSixth_value(feeType.getSixth_value());
	    feetype.setSeventh_value(feeType.getSeventh_value());
	    feetype.setEighth_value(feeType.getEighth_value());
	    feetype.setNinth_value(feeType.getNinth_value());
	    feetype.setTenth_value(feeType.getTenth_value());
	    
		feetypes.add(feetype);
	}
	}
	
	for (Fees fee : feeList){
		FeeInfo feeInfo = new FeeInfo();
		feeInfo.setFee_id(fee.getFee_id());
		feeInfo.setStandard(fee.getStandard());
		feeInfo.setTot_annual_fees((fee.getAnnual_fee()));
		feeInfo.setFee_types(feetypes);
		feesList.add(feeInfo);
		
	}
		return feesList;
		
	}



	@Override
	public boolean saveFees(FeeInfo fee) {
		Session session = sessionFactory.getCurrentSession();
		Fees fees = (Fees) session.load(Fees.class, fee.getFee_id());

		try{
	/*if(fee.getAnnual_fees()!=fees.getAnnual_fee()){
		
		fees.setAnnual_fee(fee.getAnnual_fees());
		session.update(fees);*/
			
		}catch(Exception e){
			return false;
		}
		
		
		
		
		return true;
		
	}



	@Override
	public boolean saveFeeType(FeeTypeForm feetype) {
		Session session = sessionFactory.getCurrentSession();
		FeesType fees = new FeesType();
		fees.setFee_name(feetype.getFee_name());
		fees.setFee_type(feetype.getFee_type());		
		//fees.setFee_value(0);
		ArrayList<FeesType> feestypes = 	(ArrayList<FeesType>) session.createCriteria(FeesType.class)
				.add(Restrictions.eq("fee_name", feetype.getFee_name())).list();
		
		
		
		if(feestypes.isEmpty()){
			session.save(fees);
			
		
			
			
			return true;
		}else
			return false;
		
		
	}

	
	 

  

	



}
