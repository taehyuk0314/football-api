package com.football.api.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.common.vo.CodeMasterVO;

@Service
public class CommonService {
	@Autowired
	CommonMapper commonMapper;
	
    /**
     * 공통 코드 조회
     * @param vo
     * @return
     */    
    public List<CodeMasterVO> selectCodes(CodeMasterVO vo) {
        return commonMapper.selectCodes(vo);
    }    
    
    /**
     * 공통 코드 그룹 조회
     * @param vo
     * @return
     */    
    public List<CodeMasterVO> selectCodeGroups(CodeMasterVO vo) {
    	List<CodeMasterVO> result = commonMapper.selectCodes(vo);
		for(CodeMasterVO code: result) {
			System.out.println(code);
			code.setCodes(commonMapper.selectCodeGroups(code));
		}    	
        return result;
    }    
}
