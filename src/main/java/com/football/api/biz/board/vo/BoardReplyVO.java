package com.football.api.biz.board.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardReplyVO extends BoardMasterVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer replyNo;
	Integer boardNo;
	Integer parentNo;
	String title;
	String contents;
	Integer sortNo;
	String viewType;
    Integer regUser;
    String regDt;
    Integer updUser;
    String updDt;
}
