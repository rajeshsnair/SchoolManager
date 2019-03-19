package org.schoolMgr.dao;



import java.util.ArrayList;




import org.schoolMgr.entity.Account;
import org.schoolMgr.entity.Student;
import org.schoolMgr.model.DashBoardForm;
import org.schoolMgr.model.StudentFeeForm;
import org.schoolMgr.model.StudentInfo;
import org.schoolMgr.model.UserInfo;






public interface StudentDao {


	 
	 public boolean createStudent(StudentInfo std); 
	 
	 public boolean saveStdList(ArrayList<Student> stdList);
	 
	 public ArrayList<StudentInfo> listStudents();
	 
	 public StudentFeeForm getStudentFee(int std_id);
	 
	 public boolean savePaidFees(StudentFeeForm form);
	 
	 public DashBoardForm getDashBoardDet();
	 
	 public ArrayList<StudentInfo>  listRemStudents();

	 public ArrayList<StudentInfo>  listPaidStudents();
	
}
