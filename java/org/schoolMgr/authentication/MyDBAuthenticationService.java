package org.schoolMgr.authentication;

import java.util.ArrayList;
import java.util.List;

import org.schoolMgr.dao.UserDao;
import org.schoolMgr.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
@Service
public class MyDBAuthenticationService implements UserDetailsService {
 
    @Autowired
    private UserDao userDAO;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userDAO.findAccount(username);
       
 
        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + username + " was not found in the database");
        }
 
        // EMPLOYEE,MANAGER,..
        String role = account.getRole();
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
 
        // ROLE_USER, ROLE_ADMIN
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
 
        grantList.add(authority);
 
        boolean enabled = account.isActive();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        UserDetails userDetails = (UserDetails) new User(account.getUserName(), //
                account.getPassword(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);
 
        return userDetails;
    }
 
}