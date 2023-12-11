package com.football.api.biz.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.member.vo.MemberVO;

@RestController
public class MypageController {
	@Autowired
	MypageService mypageService;
	
	@GetMapping("/mypage")
	public MemberVO selectMypage(MemberVO vo) {
		return mypageService.selectMypage(vo);
	}    
}
