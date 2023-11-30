package com.football.api.biz.member.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MemberPasswordVO extends MemberVO{
    Integer passwordNo;
    Integer memNo;
    String password;
    Integer regUser;
    String regDt;
}
