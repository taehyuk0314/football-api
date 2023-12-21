package com.football.api.biz.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.football.api.biz.product.vo.ProductVO;


@Mapper
public interface ProductMapper {
     /**
      * 상품 목록 조회
      * @param vo
      * @return
      */
     public List<ProductVO> selectProducts(ProductVO vo);
}
