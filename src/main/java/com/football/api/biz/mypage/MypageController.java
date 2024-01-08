package com.football.api.biz.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.member.vo.CartMasterVO;
import com.football.api.biz.member.vo.MemberVO;
import com.football.api.biz.mypage.vo.CartIVO;

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
	 * 장바구니 담기
	 * @param vo
	 * @return
	 */
	@PostMapping("/mypage/cart")
	public int insertCart(@RequestBody List<CartMasterVO> vo) {
		return mypageService.insertCart(vo);
	}   
	
	/**
	 * 장바구니 삭제
	 * @param vo
	 * @return
	 */
	@DeleteMapping("/mypage/cart")
	public int deleteCart(CartMasterVO vo) {
		return mypageService.deleteCart(vo);
	}   
	
	/**
	 * 장바구니 타입 조회
	 * @param vo
	 * @return
	 */
	@GetMapping("/mypage/cart")
	public List<CartMasterVO> selectMyCart(CartIVO vo) {
		return mypageService.selectMyCart(vo);
	} 	
	
	/**
	 * 최근 본 상품 조회
	 * @param vo
	 * @return
	 */
	@PostMapping("/mypage/recent-products")
	public List<CartMasterVO> selectRecentProducts(@RequestBody List<Integer> vo) {
		System.out.println(vo);
		return mypageService.selectRecentProducts(vo);
	} 	
}
