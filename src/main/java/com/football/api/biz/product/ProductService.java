package com.football.api.biz.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.product.vo.ProductVO;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    /**
     * 상품목록 조회
     * @param vo
     * @return
     */
    public List<ProductVO> selectProducts(ProductVO vo) {
        return productMapper.selectProducts(vo);
    }
}
