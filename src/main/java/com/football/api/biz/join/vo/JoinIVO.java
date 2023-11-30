package com.football.api.biz.join.vo;

import com.football.api.biz.member.vo.PasswordVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class JoinIVO extends PasswordVO {
    Integer passwordNo;
    String password;
}
