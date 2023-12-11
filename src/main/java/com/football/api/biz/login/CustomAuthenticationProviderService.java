package com.football.api.biz.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.football.api.biz.login.vo.LoginVO;
import com.football.api.security.CommonAuthenticationToken;
import com.football.api.security.CountedBadCredentialsException;
import com.football.api.security.SecurityUtils;

import jakarta.servlet.http.HttpSession;


@Component
public class CustomAuthenticationProviderService implements AuthenticationProvider {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginService loginService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	CommonAuthenticationToken token = (CommonAuthenticationToken) authentication;
		String userId = token.getName();
        LoginVO user = (LoginVO) loginService.loadUserByUsername(userId);
        
    	
    	// 회원 정보 없거나 || 비밀번호 불일치
    	if(user == null || !encoder.matches(String.valueOf(token.getCredentials()), user.getPassword())) {
    		int count = SecurityUtils.addPasswordFailedCount(session);
    		throw new CountedBadCredentialsException("bad credentials", count);
    	}
    	
    	// 로그인 성공하면 비밀번호 실패 카운트 초기화
    	SecurityUtils.clearPasswordFailedCount(session);
    	
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(CommonAuthenticationToken.class);
	}
}
