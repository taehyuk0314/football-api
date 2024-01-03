package com.football.api.biz.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.member.vo.LikeMasterVO;
import com.football.api.biz.product.vo.ProductMasterVO;
import com.football.api.biz.product.vo.ProductOptionVO;
import com.football.api.biz.product.vo.ProductVO;


@Mapper
public interface ProductMapper {
	
     /**
      * 상품 목록 조회
      * @param vo
      * @return
      */
	public List<ProductVO> selectProducts(ProductVO vo);
	
     /**
      * 상품 조회
      * @param vo
      * @return
      */
     public ProductVO selectProduct(ProductVO vo);
     
     /**
      * 상품 옵션 조회
      * @param vo
      * @return
      */
     public List<ProductOptionVO> selectProductOptions(ProductMasterVO vo);     
     
     /**
      * 상품 좋아요
      * @param vo
      * @return
      */     
     public int likeProduct(LikeMasterVO vo);
     
     /**
      * 상품 안좋아요
      * @param vo
      * @return
      */     
     public int unLikeProduct(LikeMasterVO vo);
}
