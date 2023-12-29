package com.football.api.biz.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.member.vo.MemberVO;

@RestController
public class MypageController {
	@Autowired
	MypageService mypageService;
	
	/**
	 * 마이페이지 조회
	 * @param vo
	 * @return
	 */
	@GetMapping("/mypage")
	public MemberVO selectMypage(MemberVO vo) {
		return mypageService.selectMypage(vo);
	}   
	/**
	 * 장바구니 타입 조회
	 * @param vo
	 * @return
	 */
//	@GetMapping("/mypage/cart")
//	public List<ProductVO> selectMyCart(CartIVO vo) {
//		return mypageService.selectMyCart(vo);
//	}    
}
