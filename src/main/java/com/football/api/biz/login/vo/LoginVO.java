package com.football.api.biz.login.vo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.football.api.biz.member.vo.MemberMasterVO;

import java.util.Collection;

import lombok.Getter;

@Getter
public class LoginVO extends User {
	
	private static final long serialVersionUID = 1L;
	private MemberMasterVO details;

	public LoginVO(String username, String password, Collection<? extends GrantedAuthority> authorities, MemberMasterVO details) {
		super(username, password, authorities);
		details.setPassword("!!protected!!");
		this.details = details;
	}
}