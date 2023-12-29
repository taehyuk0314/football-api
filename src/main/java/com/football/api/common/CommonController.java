package com.football.api.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.common.vo.CodeMasterVO;


@RestController
public class CommonController {
	@Autowired
	CommonService commonService;
	/**
	 * 상품목록 조회
	 * @param vo
	 * @return
	 */
	@GetMapping("/code/groups/{codeType}")
	public List<CodeMasterVO>  selectCodeGroups(CodeMasterVO vo) {
		return commonService.selectCodeGroups(vo);
	}    
}
