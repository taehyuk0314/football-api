package com.football.api.biz.mypage;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.football.api.biz.member.vo.CartMasterVO;
import com.football.api.biz.member.vo.MemberDeliveryVO;
import com.football.api.biz.member.vo.MemberMasterVO;
import com.football.api.biz.member.vo.MemberVO;
import com.football.api.biz.mypage.vo.CartIVO;

@Service
public class MypageService {

    @Autowired
    MypageMapper mypageMapper;

    /**
     * 마이페이지 조회
     * @param vo
     * @return
     */
    public MemberVO selectMypage(MemberVO vo) {
        return mypageMapper.selectMypage(vo);
    }
    
    /**
     * 장바구니 담기
     * @param vo
     * @return
     */
    public int insertCart(List<CartMasterVO> vo) {
    	for (CartMasterVO cart: vo) {
    		mypageMapper.insertCart(cart);
			
		}
    	return 1;
    }
    
	/**
	 * 장바구니 삭제
	 * @param vo
	 * @return
	 */
	public int deleteCart(CartMasterVO vo) {
		return mypageMapper.deleteCart(vo);
	}      
    
    /**
     * 장바구니 조회
     * @param vo
     * @return
     */
    public List<CartMasterVO> selectMyCart(CartIVO vo) {
    	
    	switch (vo.getCartType()) {
			case "cart": 
				return mypageMapper.selectCart(vo);
			case "liked": 
				return mypageMapper.selectLikeList(vo);
			default: 
				return null;
    	}
    }
    
    /**
     * 최근 본 상품 조회
     * @param vo
     * @return
     */    
    public List<CartMasterVO> selectRecentProducts(List<Integer> productNos ){
		if(ObjectUtils.isEmpty(productNos) || productNos.size() > 20) {
			return null;
		}    	
		
		CartIVO vo = new CartIVO();
		vo.setProductNos(productNos);
		
		return mypageMapper.selectRecentProducts(vo);		
    }    
    
	/**
	 * 주소 등록
	 * @param vo
	 * @return
	 */
	public int insertMemberDelivery(MemberDeliveryVO vo) {
		return mypageMapper.insertMemberDelivery(vo);
	} 	    
	
	/**
	 * 주소 리스트 
	 * @param vo
	 * @return
	 */
	public List<MemberDeliveryVO> selectMemberDelivery(MemberMasterVO vo) {
		return mypageMapper.selectMemberDelivery(vo);
	} 	
}
