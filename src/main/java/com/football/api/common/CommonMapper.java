package com.football.api.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.common.vo.CodeMasterVO;



@Mapper
public interface CommonMapper {
     /**
      * 상품 그룹 목록 조회
      * @param vo
      * @return
      */
     public List<CodeMasterVO> selectCodeGroups(CodeMasterVO vo);
     
     /**
      * 상품 목록 조회
      * @param vo
      * @return
      */
     public List<CodeMasterVO> selectCodes(CodeMasterVO vo);
}
