package com.football.api.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class CodeGroupVO {
	String codeGroupCd;
	String code;
	String codeGroupNm;
	List<CodeMasterVO> codes;
}
