package com.football.api.biz.member.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProfileMasterVO extends MemberProfileVO {
    Integer ProfileNo;
    String Introduction;
}
