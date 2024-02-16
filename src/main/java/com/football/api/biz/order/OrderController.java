package com.football.api.biz.order;

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
import com.football.api.biz.order.vo.OrderVO;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	/**
	 * 주문 상세 조회
	 * @param vo
	 * @return
	 */
	@GetMapping("/order/{orderNo}")
	public OrderVO selectOrder(OrderVO vo) {
		return orderService.selectOrder(vo);
	}   
	
	/**
	 * 주문 상세 저장
	 * @param vo
	 * @return
	 */
	@PostMapping("/order")
	public int insertOrder(@RequestBody OrderVO vo) {
		return orderService.insertOrder(vo);
	}   
	

}
