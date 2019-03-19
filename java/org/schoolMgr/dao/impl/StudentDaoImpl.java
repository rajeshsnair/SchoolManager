/**
 * 
 */
package org.schoolMgr.dao.impl;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar.Builder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.schoolMgr.dao.StudentDao;
import org.schoolMgr.dao.UserDao;
import org.schoolMgr.entity.Account;
import org.schoolMgr.entity.Fees;
import org.schoolMgr.entity.FeesDetail;
import org.schoolMgr.entity.Student;
import org.schoolMgr.model.DashBoardForm;
import org.schoolMgr.model.StudentFeeForm;
import org.schoolMgr.model.StudentInfo;
import org.schoolMgr.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author narajesh
 *
 */

//Transactional for Hibernate
@Transactional
public class StudentDaoImpl implements StudentDao{

	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public boolean createStudent(StudentInfo std) {
		
	try{	
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("deprecation")
		ArrayList<Student> students = 	(ArrayList<Student>) session.createCriteria(Student.class)
				.add(Restrictions.eq("adm_no", std.getAdm_no())).list();
				
		
		
		Student stud = new Student();
		
		stud.setAdm_no(std.getAdm_no());
		stud.setFirstName(std.getFirstname());
		stud.setLastName(std.getLastname());
		stud.setStandard(std.getStandard());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		java.util.Date date = 	sdf.parse(std.getDob());
		Date dt = new Date(date.getTime());
		
		stud.setDob(dt);
		
		stud.setSex(std.getSex());
		stud.setGuardian_name(std.getGuardian_name());
		stud.setContact(std.getContact());
		
		if(students.isEmpty() && std.getAdm_no()!=0){
		session.save(stud);
		
		ArrayList<Fees> fees = 	(ArrayList<Fees>) session.createCriteria(Fees.class)
				.add(Restrictions.eq("standard", std.getStandard())).list();
		
		FeesDetail feeDet = new FeesDetail();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		String paid_date = "01-01-1990";
		java.util.Date date1 = 	sdf1.parse(paid_date);
		Date dt1 = new Date(date.getTime());
		feeDet.setLast_paid_dt(dt1);
		feeDet.setAdm_no(std.getAdm_no());
		feeDet.setLast_paid_mnth("First Installment");
		feeDet.setMnthly_fees((fees.get(0).getAnnual_fee())/12);
		feeDet.setRem_fees(fees.get(0).getAnnual_fee());
		feeDet.setStd_id(std.getStd_id());
		session.save(feeDet);
		
		return true;
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
		
			return false;
	
		

	}

	@Override
	public boolean saveStdList(ArrayList<Student> stdList) {
	Session session = sessionFactory.getCurrentSession();
		
		try{
		
		for (Student std : stdList){
			
			ArrayList<Student> students = 	(ArrayList<Student>) session.createCriteria(Student.class)
					.add(Restrictions.eq("adm_no", std.getAdm_no())).list();
			
			if(students.isEmpty() && std.getAdm_no()!=0){
				
					
			session.saveOrUpdate(std);
			
			ArrayList<Fees> fees = 	(ArrayList<Fees>) session.createCriteria(Fees.class)
					.add(Restrictions.eq("standard", std.getStandard())).list();
			
			FeesDetail feeDet = new FeesDetail();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String paid_date = "01-01-1990";
			java.util.Date date = 	sdf.parse(paid_date);
			Date dt = new Date(date.getTime());
			feeDet.setLast_paid_dt(dt);
			feeDet.setAdm_no(std.getAdm_no());
			feeDet.setLast_paid_mnth("First Installment");
			feeDet.setMnthly_fees((fees.get(0).getAnnual_fee())/12);
			feeDet.setRem_fees(fees.get(0).getAnnual_fee());
			feeDet.setStd_id(std.getStd_id());
			session.save(feeDet);
			
			}
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}
       
		return true;
	}

	@Override
	public ArrayList<StudentInfo> listStudents() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Student> stdList =  (ArrayList<Student>) session.createCriteria(Student.class).list();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		ArrayList<StudentInfo> dbInfos = new ArrayList<StudentInfo>();
		for(Student std:stdList){
			
			StudentInfo stdInfo = new StudentInfo();
			stdInfo.setStd_id(std.getStd_id());
			stdInfo.setAdm_no(std.getAdm_no());
			stdInfo.setFirstname(std.getFirstName());
			stdInfo.setLastname(std.getLastName());
			stdInfo.setStandard(std.getStandard());
			stdInfo.setContact(std.getContact());
			stdInfo.setGuardian_name(std.getGuardian_name());
			stdInfo.setSex(std.getSex());
			stdInfo.setDob(sdf.format(std.getDob()));
			
			dbInfos.add(stdInfo);
			
		}
		return dbInfos;
	}

	@Override
	public StudentFeeForm getStudentFee(int std_id) {
		
		Session session = sessionFactory.getCurrentSession();
		StudentFeeForm stdForm = new StudentFeeForm();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Student std = (Student) session.load(Student.class, std_id);
		
		ArrayList<FeesDetail> feesDet = 	(ArrayList<FeesDetail>) session.createCriteria(FeesDetail.class)
				.add(Restrictions.eq("adm_no", std.getAdm_no())).list();
		
		ArrayList<Fees> fees = 	(ArrayList<Fees>) session.createCriteria(Fees.class)
				.add(Restrictions.eq("standard", std.getStandard())).list();
		
		stdForm.setStd_id(std.getStd_id());
		stdForm.setAdm_no(std.getAdm_no());
		stdForm.setFirstname(std.getFirstName());
		stdForm.setLastname(std.getLastName());
		stdForm.setStandard(std.getStandard());
		
		if(feesDet.isEmpty()){
			FeesDetail feeDet = new FeesDetail();
			
		try{	
			
			String paid_date = "01-01-1990";
		
			java.util.Date date = 	sdf.parse(paid_date);
			Date dt = new Date(date.getTime());
			feeDet.setLast_paid_dt(dt);
			feeDet.setAdm_no(std.getAdm_no());
			feeDet.setLast_paid_mnth("First Installment");
			feeDet.setMnthly_fees((fees.get(0).getAnnual_fee())/12);
			feeDet.setRem_fees(fees.get(0).getAnnual_fee());
			feeDet.setStd_id(std.getStd_id());
			session.save(feeDet);
			
			stdForm.setMnthly_fees(fees.get(0).getAnnual_fee()/12);
			stdForm.setRem_fees(fees.get(0).getAnnual_fee());
			stdForm.setLast_paid_dt(sdf.format(date));
			stdForm.setLast_paid_mnth("First Installment");
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
			
			
		}
		
		else{
		stdForm.setMnthly_fees(fees.get(0).getAnnual_fee()/12);
		stdForm.setRem_fees(feesDet.get(0).getRem_fees());
		stdForm.setLast_paid_dt(sdf.format(feesDet.get(0).getLast_paid_dt()));
		stdForm.setLast_paid_mnth(feesDet.get(0).getLast_paid_mnth());
		}
		
		
		return stdForm;
	}

	@Override
	public boolean savePaidFees(StudentFeeForm form) {
		Session session = sessionFactory.getCurrentSession();
		
		ArrayList<FeesDetail> feesDet = 	(ArrayList<FeesDetail>) session.createCriteria(FeesDetail.class)
				.add(Restrictions.eq("adm_no", form.getAdm_no())).list();
		
		String month = new SimpleDateFormat("MMMM").format(new java.util.Date());
	
		if(feesDet.get(0).getLast_paid_mnth().equals(month)){
			return false;
		}else{
			FeesDetail fee = (FeesDetail) session.load(FeesDetail.class, feesDet.get(0).getFee_det_id());
			Date dt  = new Date(new java.util.Date().getTime());
			
			fee.setLast_paid_dt(dt);
			fee.setLast_paid_mnth(month);
			fee.setRem_fees(fee.getRem_fees() - fee.getMnthly_fees());
			
			session.update(fee);
		}
		
		return true;
	}

	@Override
	public DashBoardForm getDashBoardDet() {
		Session session = sessionFactory.getCurrentSession();
		DashBoardForm dbForm = new DashBoardForm();
		int lkg_count =0;
		int ukg_count = 0;
		int ist_count = 0;
		int iind_count = 0;
		int iiird_count = 0;
		int ivth_count = 0;
		int vth_count = 0;
		int vith_count = 0;
		int viith_count = 0;
		int viiith_count = 0;
		int ixth_count = 0;
		int xth_count = 0;
		
		int paid_curr_month=0;
		
		ArrayList<String> standards = new ArrayList<String>();
		ArrayList<Integer> student_stds = new ArrayList<Integer>();
		
		ArrayList<Student> stdList = 	(ArrayList<Student>) session.createCriteria(Student.class).list();
		dbForm.setTotal_students(stdList.size());
		standards.add("LKG");
		standards.add("UKG");
		standards.add("Ist");
		standards.add("IInd");
		standards.add("IIIrd");
		standards.add("IVth");
		standards.add("Vth");
		standards.add("VIth");
		standards.add("VIIth");
		standards.add("VIIIth");
		standards.add("IXth");
		standards.add("Xth");
		dbForm.setStandards(standards);
		
		if (stdList != null && !stdList.isEmpty()) {
			for (Student std : stdList) {
				if (std.getStandard().equals("LKG")) {
					lkg_count++;
				}
				if (std.getStandard().equals("UKG")) {
					ukg_count++;
				}
				if (std.getStandard().equals("Ist")) {
					ist_count++;
				}
				if (std.getStandard().equals("IInd")) {
					iind_count++;
				}
				if (std.getStandard().equals("IIIrd")) {
					iiird_count++;
				}
				if (std.getStandard().equals("IVth")) {
					ivth_count++;
				}
				if (std.getStandard().equals("Vth")) {
					vth_count++;
				}
				if (std.getStandard().equals("VIth")) {
					vith_count++;
				}
				if (std.getStandard().equals("VIIth")) {
					viith_count++;
				}
				if (std.getStandard().equals("VIIIth")) {
					viiith_count++;
				}
				if (std.getStandard().equals("IXth")) {
					ixth_count++;
				}
				if (std.getStandard().equals("Xth")) {
					xth_count++;
				}
			}
		}
		
		student_stds.add(lkg_count);
		student_stds.add(ukg_count);
		student_stds.add(ist_count);
		student_stds.add(iind_count);
		student_stds.add(iiird_count);
		student_stds.add(ivth_count);
		student_stds.add(vth_count);
		student_stds.add(vith_count);
		student_stds.add(viith_count);
		student_stds.add(viiith_count);
		student_stds.add(ixth_count);
		student_stds.add(xth_count);
		dbForm.setStandard_students(student_stds);
		
		ArrayList<FeesDetail> feedet = 	(ArrayList<FeesDetail>) session.createCriteria(FeesDetail.class).list();
		String curr_month = new SimpleDateFormat("MMMM").format(new java.util.Date());
		if(feedet!=null && !feedet.isEmpty()){
			for(FeesDetail fee:feedet){
				if(fee.getLast_paid_mnth().equals(curr_month)){
					paid_curr_month++;
				}
			}
			
		}
		dbForm.setPaid_curr_month(paid_curr_month);
		dbForm.setRem_curr_month(stdList.size() - paid_curr_month);
		dbForm.setCurr_month(curr_month);
		
		return dbForm;
	}

	@Override
	public ArrayList<StudentInfo> listRemStudents() {
		String curr_month = new SimpleDateFormat("MMMM").format(new java.util.Date());
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Student> stdList =  (ArrayList<Student>) session.createCriteria(Student.class).list();
		
		
		ArrayList<StudentInfo> studInfos = new ArrayList<StudentInfo>();
		for(Student std:stdList){
			ArrayList<FeesDetail> feesDet = 	(ArrayList<FeesDetail>) session.createCriteria(FeesDetail.class)
					.add(Restrictions.eq("adm_no", std.getAdm_no())).list();
			
			if(feesDet!=null && !feesDet.isEmpty()){
				if(!feesDet.get(0).getLast_paid_mnth().equals(curr_month)){
					StudentInfo stdInfo = new StudentInfo();
					stdInfo.setStd_id(std.getStd_id());
					stdInfo.setAdm_no(std.getAdm_no());
					stdInfo.setFirstname(std.getFirstName());
					stdInfo.setLastname(std.getLastName());
					stdInfo.setStandard(std.getStandard());
					studInfos.add(stdInfo);
				}
				
			}
			
			
			
		}
		return studInfos;
	}
	

	@Override
	public ArrayList<StudentInfo> listPaidStudents() {
		String curr_month = new SimpleDateFormat("MMMM").format(new java.util.Date());
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Student> stdList =  (ArrayList<Student>) session.createCriteria(Student.class).list();
		
		
		ArrayList<StudentInfo> studInfos = new ArrayList<StudentInfo>();
		for(Student std:stdList){
			ArrayList<FeesDetail> feesDet = 	(ArrayList<FeesDetail>) session.createCriteria(FeesDetail.class)
					.add(Restrictions.eq("adm_no", std.getAdm_no())).list();
			
			if(feesDet!=null && !feesDet.isEmpty()){
				if(feesDet.get(0).getLast_paid_mnth().equals(curr_month)){
					StudentInfo stdInfo = new StudentInfo();
					stdInfo.setStd_id(std.getStd_id());
					stdInfo.setAdm_no(std.getAdm_no());
					stdInfo.setFirstname(std.getFirstName());
					stdInfo.setLastname(std.getLastName());
					stdInfo.setStandard(std.getStandard());
					studInfos.add(stdInfo);
				}
				
			}
			
			
			
		}
		return studInfos;
	}
	

	



}
