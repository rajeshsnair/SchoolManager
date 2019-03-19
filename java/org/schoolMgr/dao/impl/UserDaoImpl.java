/**
 * 
 */
package org.schoolMgr.dao.impl;


import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.schoolMgr.dao.UserDao;
import org.schoolMgr.entity.Account;
import org.schoolMgr.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author narajesh
 *
 */

//Transactional for Hibernate
@Transactional
public class UserDaoImpl implements UserDao{

	 @Autowired
	 private SessionFactory sessionFactory;

	@Override 
	public Account findAccount(String userName) {
	     Session session = sessionFactory.getCurrentSession();
	      @SuppressWarnings("deprecation")
		Criteria crit = session.createCriteria(Account.class);
	        crit.add(Restrictions.eq("userName", userName));
	        return (Account) crit.uniqueResult();
	}

	@Override
	public boolean createAccount(UserInfo user) {
		Session session = sessionFactory.getCurrentSession();
		Account acc = new Account();
		acc.setActive(true);
		acc.setPhone(user.getPhone());
		acc.setDesignation(user.getDesignation());
		acc.setFirstName(user.getFirstName());
		acc.setLastName(user.getLastName());
		acc.setPassword(user.getPassword());
		acc.setRole(user.getRole());
		acc.setUserName(user.getUserName());
		//acc.setUserId(1014);
		acc.setEmail(user.getEmail());
		
		session.save(acc);
		
		
		return true;
	}

	@Override
	public ArrayList<Account> listUsers() {
		
		Session session = sessionFactory.getCurrentSession();
	ArrayList<Account> accountList =	(ArrayList<Account>) session.createCriteria(Account.class).list();
		return accountList;
	}

	@Override
	public boolean deleteUser(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Account user;
		user = (Account) session.load(Account.class, user_id);
		session.delete(user);
		// TODO Auto-generated method stub
		session.flush();
		return true;
	}
	 

  

	



}
