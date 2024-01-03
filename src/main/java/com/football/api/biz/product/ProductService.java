package com.football.api.biz.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.like.LikeMapper;
import com.football.api.biz.member.vo.LikeMasterVO;
import com.football.api.biz.product.vo.ProductMasterVO;
import com.football.api.biz.product.vo.ProductOptionVO;
import com.football.api.biz.product.vo.ProductVO;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;
    
    @Autowired
    LikeMapper likeMapper;

    /**
     * 상품목록 조회
     * @param vo
     * @return
     */
    public List<ProductVO> selectProducts(ProductVO vo) {
        return productMapper.selectProducts(vo);
    }
    
    /**
     * 상품조회
     * @param vo
     * @return
     */
    public ProductVO selectProduct(ProductVO vo) {
    	ProductVO result = new ProductVO();
    	result = productMapper.selectProduct(vo);
    	result.setOptions(productMapper.selectProductOptions(result));
    	return result;
    }
    /**
     * 상품 옵션 조회
     * @param vo
     * @return
     */
    public List<ProductOptionVO> selectProductOptions(ProductMasterVO vo) {
        return productMapper.selectProductOptions(vo);
    }    
    
	/**
	 * 상품 좋아요
	 * @param vo
	 * @return
	 */
	public int likeProduct(LikeMasterVO vo) {
		likeMapper.insertLike(vo);
		return productMapper.likeProduct(vo);
	}        
	
	/**
	 * 상품 안좋아요
	 * @param vo
	 * @return
	 */
	public int unlikeProduct(LikeMasterVO vo) {
		likeMapper.deleteLike(vo);
		return productMapper.unLikeProduct(vo);
	}        
}
