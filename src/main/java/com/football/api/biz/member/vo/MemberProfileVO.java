package com.football.api.biz.member.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MemberProfileVO extends MemberMasterVO{
    Integer MemNo;
    Integer ProfileNo;
}
