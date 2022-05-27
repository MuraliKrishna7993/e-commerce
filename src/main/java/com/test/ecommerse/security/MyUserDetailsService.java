//package com.test.ecommerse.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.test.ecommerse.model.User;
//import com.test.ecommerse.repository.UserRepository;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private UserRepository repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		User user = repo.findByUserName(username);
//		
//		if(user==null)
//			throw new UsernameNotFoundException("not found");
//		
//		return new UserPrincipal(user);
//	}
//
//}
