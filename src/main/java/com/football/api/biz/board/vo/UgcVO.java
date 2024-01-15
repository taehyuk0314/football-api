package com.football.api.biz.board.vo;

import java.util.List;



import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UgcVO extends BoardUgcVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<BoardUgcVO> bestUgcs;
	List<BoardUgcVO> recommendUgcs;
}
