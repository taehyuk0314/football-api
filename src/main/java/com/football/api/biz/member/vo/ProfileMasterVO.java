package com.football.api.biz.member.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProfileMasterVO extends MemberProfileVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer profileNo;
    String introduction;
}
