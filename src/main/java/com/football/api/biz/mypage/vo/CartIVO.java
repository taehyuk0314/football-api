package com.football.api.biz.mypage.vo;

import java.util.List;

import com.football.api.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CartIVO extends CommonVO{
	String cartType;
	List<Integer> productNos;
}
