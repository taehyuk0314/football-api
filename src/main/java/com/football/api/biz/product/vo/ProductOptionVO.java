package com.football.api.biz.product.vo;


import java.math.BigDecimal;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductOptionVO extends ProductMasterVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer optionNo;
	String optionNm;
	BigDecimal optionCnt;
	String viewType;
	Integer regUser;
	String regDt;
	Integer updUser;
	String updDt;
	Integer productNo;

}
