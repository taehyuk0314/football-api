package com.football.api.biz.order.vo;

import java.math.BigDecimal;
import java.util.List;

import com.football.api.biz.member.vo.CartMasterVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderMasterVO extends CartMasterVO {
	private static final long serialVersionUID = 1L;
	
	Integer orderNo;
	String orderType;
	BigDecimal orderCnt;
	BigDecimal orderPrice;
	String paymentType;
	BigDecimal paymentTotalPrice;
	String addr;
	String addrDetail;
	String viewType;
	Integer regUser;
	String regDt;
	Integer updUser;
	String updDt;
	List<OrderProductVO> products;
}
