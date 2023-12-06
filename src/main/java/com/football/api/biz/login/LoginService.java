package com.football.api.biz.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.football.api.biz.join.vo.JoinIVO;
import com.football.api.biz.login.vo.LoginVO;
import com.football.api.biz.member.MemberMapper;
import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.common.Constants;
import com.football.api.exception.BussinessException;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
	PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     * @param vo
     * @return
     * @throws BussinessException
     */
    public int insertMember(JoinIVO vo) throws BussinessException {
        //TODO 유효성검사
        //아이디 중복체크
        MemberMasterVO member = memberMapper.selectMemberById(vo.getMemId());
        if(member != null) {
			// "a0001": "중복된 아이디 입니다. 다른 아이디로 가입해 주세요."
			throw new BussinessException("member.a0001");            
        }
        //TODO selectMemberByNickNm 닉네임 중복체크
        vo.setMemTypeCd("001001");
        //회원마스터 생성
        memberMapper.insertMemberMaster(vo);
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        //회원 비밀번호 테이블 생성
        memberMapper.insertMemberPassword(vo);
        //회원마스터 수정(비밀번호 넘버 넣어주기)
        memberMapper.updateJoinMemberMaster(vo);

        return 1;
    }
   /**
    * 로그인 정보 조회 
    * @param memId
    * @return
    * @throws UsernameNotFoundException
    */
    @Override
    public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
    	MemberMasterVO member = memberMapper.selectMemberById(memId);
    	return this.getLoginVoByMember(member);
    }
    
    /**
     * MemberVO로 Login Token 취득
     * @param member
     * @return
     */
    public LoginVO getLoginVoByMember(MemberMasterVO member) {
    	// 존재하는 회원이 없을 경우 CustomAuthenticationProvider 구현체에서 Exception 발생
    	if(member == null) {
    		return null;
    	}
    	String userId = String.valueOf(member.getMemId());
    	
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	
    	SimpleGrantedAuthority simpleGrantedAuthority = null;
    	
    	switch(member.getMemTypeCd()) {
    	case "001001":
    		simpleGrantedAuthority = new SimpleGrantedAuthority(Constants.ROLE_MEMBER);
    		break;
    	}
    	if(simpleGrantedAuthority == null) {
    		return null;
    	}
    	
		authorities.add(simpleGrantedAuthority);
    	
    	return new LoginVO(userId, member.getPassword(), authorities, member); 
    }
}
