package com.football.api.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.member.vo.MemberVO;

@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    /**
     * 회원정보 조회
     * @param vo
     * @return
     */
    public MemberVO selectMember(MemberVO vo) {
        return memberMapper.selectMember(vo);
    }
}
