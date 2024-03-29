package com.football.api.biz.board.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardUgcVO extends BoardMasterVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer boardNo;
    String ugcTypeCd;
    Boolean useReply;
    Boolean useNickname;
}
