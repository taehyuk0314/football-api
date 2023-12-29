package com.football.api.biz.mypage.vo;

import com.football.api.biz.member.vo.MemberVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MypageVO extends MemberVO {
	private static final long serialVersionUID = 1L;
	
	Integer totalPoint;
}
