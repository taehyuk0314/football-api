package com.football.api.biz.product.vo;


import java.math.BigDecimal;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductMasterVO extends BrandMasterVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	Integer productNo;
	String productTypeCd;
	String productNm;
	Integer brandNo;
	Integer minProductCount;
	Integer maxProductCount;
	BigDecimal price;
	BigDecimal salePrice;
	BigDecimal totalPrice;
	BigDecimal likeCnt;
    String viewType;
    Integer regUser;
    String regDt;
    Integer updUser;
    String updDt;

}
