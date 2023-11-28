package com.football.api.biz.board.vo;

import lombok.Data;

@Data
public class BoardMasterVO {
    Integer boardNo;
    String boardTypeCd;
    String title;
    String contents;
    Integer regUser;
    String regDt;
    Integer updUser;
    String updDt;
}
