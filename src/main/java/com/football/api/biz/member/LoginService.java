package com.football.api.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.join.vo.JoinIVO;

@Service
public class LoginService {
    @Autowired
    MemberMapper memberMapper;
    
    /**
     * 회원가입
     * @param vo
     * @return
     */
    public int insertMember(JoinIVO vo) {
        //회원마스터 생성
        memberMapper.insertMemberMaster(vo);
        //회원 비밀번호 테이블 생성
        memberMapper.insertMemberPassword(vo);
        //회원마스터 수정(비밀번호 넘버 넣어주기)
        memberMapper.updateJoinMemberMaster(vo);

        return 1;
    }
}
