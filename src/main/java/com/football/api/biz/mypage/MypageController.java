package com.football.api.biz.mypage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.mypage.vo.MypageVO;

@RestController
public class MypageController {

	@GetMapping("/mypage/{memNo}")
	public MypageVO selectProfile(MypageVO vo) {
		return vo;
	}    
}
