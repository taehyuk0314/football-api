package com.football.api.biz.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.member.vo.MemberVO;

@Service
public class MypageService {

    @Autowired
    MypageMapper mypageMapper;

    /**
     * 마이페이지 조회
     * @param vo
     * @return
     */
    public MemberVO selectMypage(MemberVO vo) {
        return mypageMapper.selectMypage(vo);
    }
}
