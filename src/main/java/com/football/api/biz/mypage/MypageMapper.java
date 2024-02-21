package com.football.api.biz.mypage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.member.vo.CartMasterVO;
import com.football.api.biz.member.vo.MemberDeliveryVO;
import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.biz.member.vo.MemberVO;
import com.football.api.biz.mypage.vo.CartIVO;


@Mapper
public interface MypageMapper {
     /**
      * 마이페이지 조회
      * @param vo
      * @return
      */
     public MemberVO selectMypage(MemberVO vo);
     
     /**
      * 장바구니 담기
      * @param vo
      * @return
      */
     public int insertCart(CartMasterVO vo);
     
     /**
      * 장바구니 리스트
      * @param vo
      * @return
      */
     public List<CartMasterVO> selectCart(CartIVO vo);
     
 	/**
 	 * 장바구니 삭제
 	 * @param vo
 	 * @return
 	 */
 	public int deleteCart(CartMasterVO vo);
 	
     /**
      * 좋아요 리스트
      * @param vo
      * @return
      */
     public List<CartMasterVO> selectLikeList(CartIVO vo);
     
     /**
      * 최근 본 상품 조회
      * @param vo
      * @return
      */    
     public List<CartMasterVO> selectRecentProducts(CartIVO vo);     
     
 	/**
 	 * 주소 등록
 	 * @param vo
 	 * @return
 	 */
 	public int insertMemberDelivery(MemberDeliveryVO vo);
 	
	/**
	 * 주소 리스트 
	 * @param vo
	 * @return
	 */
	public List<MemberDeliveryVO> selectMemberDelivery(MemberMasterVO vo);
}
