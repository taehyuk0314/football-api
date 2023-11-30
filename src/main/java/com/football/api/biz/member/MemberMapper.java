package com.football.api.biz.member;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.biz.member.vo.MemberPasswordVO;


@Mapper
public interface MemberMapper {
	/**
     * 회원마스터 저장
     * @param vo
     * @return
     */
	public int insertMemberMaster(MemberMasterVO vo);    

	/**
     * 회원가입 회원마스터 수정
     * @param vo
     * @return
     */
	public int updateJoinMemberMaster(MemberMasterVO vo);   

	/**
     * 비밀번호 마스터 저장
     * @param vo
     * @return
     */
	public int insertMemberPassword(MemberPasswordVO vo);    
}
