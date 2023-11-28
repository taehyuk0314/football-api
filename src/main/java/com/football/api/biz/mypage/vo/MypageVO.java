package com.football.api.biz.mypage.vo;

import com.football.api.biz.member.vo.MemberMasterVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MypageVO extends MemberMasterVO {
    Integer TotalPoint;
}
