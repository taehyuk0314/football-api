package com.football.api.biz.board.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardUgcVO extends BoardMasterVO {
    Integer boardNo;
    Boolean useReply;
    Boolean useNickname;
}
