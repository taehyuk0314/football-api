package com.football.api.biz.login.vo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.football.api.biz.member.vo.MemberMasterVO;

import java.util.Collection;

import lombok.Getter;

@Getter
public class LoginVO extends User {
	
	private MemberMasterVO details;

	public LoginVO(String username, String password, Collection<? extends GrantedAuthority> authorities, MemberMasterVO details) {
		super(username, password, authorities);
		details.setMemPwd("!!protected!!");
		this.details = details;
	}
}