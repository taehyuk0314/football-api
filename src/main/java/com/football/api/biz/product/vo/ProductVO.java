package com.football.api.biz.product.vo;


import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductVO  extends ProductOptionVO {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ProductOptionVO> options;
	
}
