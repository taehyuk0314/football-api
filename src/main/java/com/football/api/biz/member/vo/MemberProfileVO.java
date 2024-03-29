package com.football.api.biz.member.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class MemberProfileVO extends MemberMasterVO{
    Integer memNo;
    Integer profileNo;
}
