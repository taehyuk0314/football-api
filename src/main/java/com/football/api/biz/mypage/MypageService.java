package com.football.api.biz.mypage;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.football.api.biz.member.vo.CartMasterVO;
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
}
