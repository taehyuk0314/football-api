package com.football.api.biz.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.join.vo.JoinIVO;
import com.football.api.biz.login.vo.LoginIVO;
import com.football.api.biz.member.MemberService;
import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.exception.BussinessException;
import com.football.api.security.CommonAuthenticationToken;
import com.football.api.security.SecurityUtils;


@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	/**
	 * 로그인
	 * @param fcmUserToken
	 * @param userAgent
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public MemberMasterVO login(@CookieValue(value = "FcmUserToken", defaultValue = "") String fcmUserToken, @CookieValue(value = "UserApp", defaultValue = "") String userAgent, @RequestBody LoginIVO vo) throws Exception {
		
		Authentication token = new CommonAuthenticationToken(vo.getMemId(), vo.getPassword(), fcmUserToken, userAgent);
		System.out.println("도저히"+ token);
		Authentication auth = authenticationManager.authenticate(token);
		System.out.println("몰라");
		SecurityContextHolder.getContext().setAuthentication(auth);
		System.out.println("ㅋㅋ");
		MemberMasterVO member = SecurityUtils.getUserDetails();
		
		return member;
	}


    /**
     * 회원 가입
     * @param vo
     * @return
     */
	@PostMapping("/join")
	public int insertMember(@RequestBody JoinIVO vo) throws BussinessException {
		return loginService.insertMember(vo);    
  }
    
}
