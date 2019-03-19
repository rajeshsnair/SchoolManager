package org.schoolMgr.dao;



import java.util.ArrayList;




import org.schoolMgr.entity.Account;
import org.schoolMgr.model.UserInfo;






public interface UserDao {


	 public Account findAccount(String userName );
	 
	 public boolean createAccount(UserInfo user); 
	 
	 public ArrayList<Account> listUsers();
	 
	 public boolean deleteUser(int user_id);
	
}
