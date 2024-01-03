package com.football.api.biz.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.biz.member.vo.LikeMasterVO;
import com.football.api.biz.product.vo.ProductVO;


@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	/**
	 * 상품목록 조회
	 * @param vo
	 * @return
	 */
	@GetMapping("/products")
	public List<ProductVO>  selectProducts(ProductVO vo) {
		return productService.selectProducts(vo);
	}    
	
	/**
	 * 상품 조회
	 * @param vo
	 * @return
	 */
	@GetMapping("/product/{productNo}")
	public ProductVO selectProduct(ProductVO vo) {
		return productService.selectProduct(vo);
	}    
	
	/**
	 * 상품 좋아요
	 * @param vo
	 * @return
	 */
	@PostMapping("/product/like")
	public int likeProduct(@RequestBody LikeMasterVO vo) {
		return productService.likeProduct(vo);
	}    
	
	/**
	 * 상품 좋아요
	 * @param vo
	 * @return
	 */
	@DeleteMapping("/product/like")
	public int unLikeProduct(LikeMasterVO vo) {
		return productService.unlikeProduct(vo);
	}    
}
