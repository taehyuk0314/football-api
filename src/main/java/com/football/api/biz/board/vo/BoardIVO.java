package com.football.api.biz.board.vo;


import com.football.api.common.aspect.vo.PaginationIVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardIVO extends PaginationIVO {
	Integer boardNo;
	String ugcTypeCd;
	Boolean isRandom;
}
