package com.football.api.security;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.football.api.biz.login.vo.LoginVO;
import com.football.api.biz.member.vo.MemberMasterVO;

import jakarta.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;
@UtilityClass
public class SecurityUtils {
    		
	/**
	 * 비밀번호 틀린 횟수+
	 */
	public static final String PASSWORD_FAILED_COUNT = "PASSWORD_FAILED_COUNT";

    /**
     * 로그인정보
     * @return
     */
	public static MemberMasterVO getUserDetails() {
		try {
			LoginVO principal = (LoginVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return principal.getDetails();
		} catch(Exception e) {
			// ignore
			return null;
		}
	}

	/**
	 * 비밀번호 틀린 횟수 입력
	 * @param session
	 */
	public static int addPasswordFailedCount(HttpSession session) {
		session.setMaxInactiveInterval(60); // 1분
		int count = getPasswordFailedCount(session);
		session.setAttribute(PASSWORD_FAILED_COUNT, ++count);
		
		if(count >= 5) {
			throw new DisabledException("로그인 실패 5회 초과");
		}
		
		return count;
	}
    
	/**
	 * 비밀번호 틀린 횟수
	 * @param session
	 * @return
	 */
	public static int getPasswordFailedCount(HttpSession session) {
		Object result = session.getAttribute(PASSWORD_FAILED_COUNT);
		if(result == null) {
			result = 0;
		}
		if((int)result >= 5) {
			throw new DisabledException("로그인 실패 5회 초과");
		}
		return (int)result;
	}    
	
	/**
	 * 비밀번호 틀린 횟수 초기화
	 */
	public static void clearPasswordFailedCount(HttpSession session) {
		session.removeAttribute(PASSWORD_FAILED_COUNT);
//		session.setMaxInactiveInterval(SecurityConfiguration.SESSION_TIMEOUT);
	}
	
	/**
	 * 간략 유저 정보
	 * 
	 * @return
	 */
	public MemberMasterVO getSimpleUserDetails() {
		MemberMasterVO temp = getUserDetails();
		System.out.println(temp);
		if(temp == null) {
			return null;
		}
		MemberMasterVO member = new MemberMasterVO();
		
		member.setMemNo(temp.getMemNo());
		member.setMemNm(temp.getMemNm());
		member.setMemTypeCd(temp.getMemTypeCd());

		return member;
	}	
}
