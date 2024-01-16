package com.football.api.biz.member;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.biz.member.vo.MemberPasswordVO;
import com.football.api.biz.member.vo.MemberProfileVO;
import com.football.api.biz.member.vo.MemberVO;
import com.football.api.biz.member.vo.ProfileMasterVO;


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
	
	/**
	 * memberProfile 저장
	 * @param vo
	 * @return
	 */
	public int insertMemberProfile(MemberProfileVO vo);    
	
	/**
	 * profileMaster 저장
	 * @param vo
	 * @return
	 */
	public int insertProfileMaster(ProfileMasterVO vo);    

	/**
     * 아이디 중복 체크
     * @param vo
     * @return
     */
	public MemberMasterVO selectMemberById(String memId);    
     
     /**
      * 회원정보 조회
      * @param vo
      * @return
      */
     public MemberVO selectMember(MemberVO vo);
}
