package com.football.api.biz.member.vo;

import lombok.Data;

@Data
public class MemberMasterVO {
    Integer memNo;
    String memTypeCd;
    String memId;
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
}
