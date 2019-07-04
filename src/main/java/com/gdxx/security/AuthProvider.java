package com.gdxx.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.gdxx.entity.User;
import com.gdxx.service.UserService;
/*
 * 自定义认证实现
 */
public class AuthProvider implements AuthenticationProvider {
	@Autowired
	private UserService userService;
	
	private final Md5PasswordEncoder passwordEncoder=new Md5PasswordEncoder();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName=authentication.getName();
		String inputPassword=(String)authentication.getCredentials();
		
		//从数据库读取登陆信息
		User user=userService.findUserByName(userName);
		if(user==null) {
			throw new AuthenticationCredentialsNotFoundException("authError");
		}
		
		if(this.passwordEncoder.isPasswordValid(user.getPassword(), inputPassword, user.getId())) {
			return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}
		throw new BadCredentialsException("authError");
	}

	// 支持所有的认证类
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
