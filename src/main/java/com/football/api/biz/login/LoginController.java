package com.football.api.biz.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
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

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	HttpSession session;	
	
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
		Authentication token = new CommonAuthenticationToken(vo.getId(), vo.getPassword(), fcmUserToken, userAgent);
		Authentication auth = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(auth);
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
 
	/**
	 * 간략 유저 정보
	 * @return
	 */
	@GetMapping("/login/simple-details")
	public MemberMasterVO selectSimpleDetails() {
		return SecurityUtils.getSimpleUserDetails();
	}	
	/**
	 * 로그아웃
	 * @return
	 */	
	@GetMapping("/logout")
	public void logout() {
		SecurityContextHolder.clearContext();
		this.session.invalidate();
	}
	
}	
