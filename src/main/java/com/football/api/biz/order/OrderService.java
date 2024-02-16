package com.football.api.biz.order;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.biz.order.vo.OrderMasterVO;
import com.football.api.biz.order.vo.OrderProductVO;
import com.football.api.biz.order.vo.OrderVO;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    /**
     * 주문 조회
     * @param vo
     * @return
     */
    public OrderVO selectOrder(OrderMasterVO vo) {
    	OrderVO result = new OrderVO();
    	result = orderMapper.selectOrder(vo);
    	result.setProducts(orderMapper.selectOrderProducts(vo));
        return result;
    }
    
    /**
     * 주문 저장
     * @param vo
     * @return
     */
    public int insertOrder(OrderVO vo) {
    	orderMapper.insertOrder(vo);
    	for(OrderProductVO product: vo.getProducts()) {
    		product.setOrderNo(vo.getOrderNo());
    		orderMapper.insertOrderProduct(product);
    	}    	
    	return vo.getOrderNo();
    }
    
}
