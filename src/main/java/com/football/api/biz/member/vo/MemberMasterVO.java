package com.football.api.biz.member.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.football.api.common.vo.CommonVO;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MemberMasterVO  extends CommonVO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer memNo;
    String memTypeCd;
    String memId;
    @JsonIgnore
	String memPwd;
    Integer passwordNo;
    String memNm;
    String nickNm;
    String phone;
    String email;
    String gender;
    String birth;
    String viewType;
    Integer regUser;
    String regDt;
    Integer updUser;
    String updDt;
    
    String password;
}
