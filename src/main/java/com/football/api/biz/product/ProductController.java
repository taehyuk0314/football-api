package com.football.api.biz.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
