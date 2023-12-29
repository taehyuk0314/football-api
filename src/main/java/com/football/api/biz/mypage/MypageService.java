package com.football.api.biz.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.member.vo.MemberVO;
import com.football.api.biz.product.vo.ProductVO;

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
//    
//    /**
//     * 장바구니 조회
//     * @param vo
//     * @return
//     */
//    public List<ProductVO> selectMyCart(CartIVO vo) {
//    	switch (vo.getCartType()) {
//			case "cart": 
//				return null;
//			case "liked": 
//				return null;
//			default: 
//				return null;
//    	}
//    }
}
