package com.football.api.common.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CodeMasterVO extends CodeGroupVO{
	String codeType;
	String codTypeNm;
	String code;
	String codeNm;
	String viewType;
	Integer sortNo;
}
