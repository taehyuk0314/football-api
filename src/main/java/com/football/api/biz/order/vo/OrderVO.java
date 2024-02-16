package com.football.api.biz.order.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderVO extends OrderMasterVO {
	private static final long serialVersionUID = 1L;
	
	Integer totalPoint;
}
