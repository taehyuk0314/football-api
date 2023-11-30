package com.football.api.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.football.api.biz.join.vo.JoinIVO;
import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.exception.BussinessException;

@Service
public class LoginService {
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
        //회원마스터 생성
        memberMapper.insertMemberMaster(vo);
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        //회원 비밀번호 테이블 생성
        memberMapper.insertMemberPassword(vo);
        //회원마스터 수정(비밀번호 넘버 넣어주기)
        memberMapper.updateJoinMemberMaster(vo);

        return 1;
    }
}
