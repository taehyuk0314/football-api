package com.football.api.biz.order.vo;

import java.math.BigDecimal;

import com.football.api.biz.member.vo.CartMasterVO;
import com.football.api.biz.member.vo.MemberVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderProductVO extends CartMasterVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer seq;
	Integer orderNo;
	Integer optionNo;
	BigDecimal orderCnt;
	String optionNm;
	String productNm;
	BigDecimal discountPrice;
	BigDecimal discountRate;
	BigDecimal totalPrice;
	String viewType;
	Integer regUser;
	String regDt;
	Integer updUser;
	String updDt;
}
