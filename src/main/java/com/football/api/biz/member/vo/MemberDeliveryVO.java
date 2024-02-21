package com.football.api.biz.member.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MemberDeliveryVO extends ProfileMasterVO  {
	private static final long serialVersionUID = 1L;
	Integer deliveryNo;
	Integer memNo;
	String postNo;
	String addr;
	String addrDetail;
	Integer addrSerialNo;
	String addrType;
	String recvNm;
	String hpNo;
	String city;
	Boolean defaultDlvryYn;
	String viewType;
	Integer regUser;
	String regDt;
	Integer updUser;
	String updDt;
}
