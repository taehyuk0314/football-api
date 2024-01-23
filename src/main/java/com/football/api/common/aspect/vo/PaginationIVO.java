package com.football.api.common.aspect.vo;


import com.football.api.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaginationIVO extends CommonVO {
	Integer pageStart;
	Integer pageLength;
	
	String startDt;
	String endDt;
	
	String searchText;
}
