package com.football.api.biz.board.vo;

import java.math.BigDecimal;
import java.util.List;

import com.football.api.biz.member.vo.LikeMasterVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardMasterVO extends LikeMasterVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer boardNo;
    String boardTypeCd;
    String title;
    String contents;
    BigDecimal likeCnt;
    BigDecimal viewCnt;
    Integer regUser;
    String regDt;
    Integer updUser;
    String updDt;
    
    List<BoardReplyVO> replies;
}
