package com.football.api.biz.member.vo;


import java.math.BigDecimal;

import com.football.api.biz.product.vo.ProductVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CartMasterVO extends ProductVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer cartNo;
	Integer optionNo;
	BigDecimal orderCnt;
	Integer memNo;
	Integer regUser;
	String regDt;
	Integer updUser;
	String updDt;
}
