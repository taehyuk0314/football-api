package com.football.api.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.common.vo.CodeMasterVO;



@Mapper
public interface CommonMapper {
     /**
      * 공통 코드 그룹 조회
      * @param vo
      * @return
      */
     public List<CodeMasterVO> selectCodeGroups(CodeMasterVO vo);
     
     /**
      * 공통 코드 목록 조회
      * @param vo
      * @return
      */
     public List<CodeMasterVO> selectCodes1(CodeMasterVO vo);
}
