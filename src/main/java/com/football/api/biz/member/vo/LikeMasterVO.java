package com.football.api.biz.member.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LikeMasterVO extends MemberVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer likeNo;
	String likeTypeCd;
	Integer targetNo;
	Integer regUser;
	String regDt;
	Boolean isLiked;
}
