package com.football.api.biz.mypage;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.biz.member.vo.MemberPasswordVO;
import com.football.api.biz.member.vo.MemberVO;


@Mapper
public interface MypageMapper {
     /**
      * 마이페이지 조회
      * @param vo
      * @return
      */
     public MemberVO selectMypage(MemberVO vo);
}
