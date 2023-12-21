package com.football.api.biz.product.vo;


import com.football.api.biz.member.vo.LikeMasterVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BrandMasterVO extends LikeMasterVO {
	Integer brandNo;
	String brandTypeCd;
	String brandNm;
	String viewType;
    Integer regUser;
    String regDt;
    Integer updUser;
    String updDt;

}
