package com.football.footballapi.mypage.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import member.vo.MemberMasterVO;

@Data
@EqualsAndHashCode(callSuper = false)
public class MypageVO extends MemberMasterVO {
    Integer TotalPoint;
}
