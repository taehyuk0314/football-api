package com.football.api.biz.member.vo;

import com.football.api.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LikeMasterVO extends CommonVO {
	Integer likeNo;
	String likeTypeCd;
	Integer targetNo;
	Integer regUser;
	String regDt;
}
