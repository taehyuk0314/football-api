package com.football.api.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.join.vo.JoinIVO;
import com.football.api.exception.BussinessException;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
    /**
     * 회원 가입
     * @param vo
     * @return
     */
	@PostMapping("/member")
	public int insertMember(@RequestBody JoinIVO vo) throws BussinessException {
		return loginService.insertMember(vo);    
    }
}
