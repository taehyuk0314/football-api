package com.football.api.biz.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.member.vo.CartMasterVO;
import com.football.api.biz.member.vo.MemberVO;
import com.football.api.biz.mypage.vo.CartIVO;
import com.football.api.biz.order.vo.OrderMasterVO;
import com.football.api.biz.order.vo.OrderProductVO;
import com.football.api.biz.order.vo.OrderVO;


@Mapper
public interface OrderMapper {
     /**
      * 주문 조회
      * @param vo
      * @return
      */
	 public OrderVO selectOrder(OrderMasterVO vo);
	 
	 /**
	  * 주문 상품 조회
	  * @param vo
	  * @return
	  */
	 public List<OrderProductVO> selectOrderProducts(OrderMasterVO vo);
     
     /**
      * 주문 저장
      * @param vo
      * @return
      */
     public int insertOrder(OrderMasterVO vo);
     
     /**
      * 주문 수정
      * @param vo
      * @return
      */
     public int updateOrder(OrderMasterVO vo);
     
     /**
      * 주문상품 저장
      * @param vo
      * @return
      */
     public int insertOrderProduct(OrderProductVO vo);
     
}
