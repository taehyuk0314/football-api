package com.football.footballapi.mypage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.footballapi.mypage.vo.MypageVO;

@RestController
public class MypageController {

	@GetMapping("/mypage/{memNo}")
	public MypageVO selectBoard(MypageVO vo) {
		return vo;
	}    
}
