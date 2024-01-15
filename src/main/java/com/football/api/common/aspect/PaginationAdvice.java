package com.football.api.common.aspect;

import org.apache.commons.lang3.math.NumberUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.football.api.common.aspect.vo.PaginationIVO;
import com.github.pagehelper.PageHelper;



@Aspect
@Component
public class PaginationAdvice {
	@Before("execution(public com.github.pagehelper.Page com.football..*Service.*(..))")
	public void paging(JoinPoint joinPoint) throws Throwable {

		try {
			
			for(Object o : joinPoint.getArgs()) {
				if(o instanceof PaginationIVO) {
					PaginationIVO pvo = (PaginationIVO)o;
					
					int start = NumberUtils.createInteger( pvo.getPageStart() );
					int length = NumberUtils.createInteger( pvo.getPageLength() );
					
					if(length == 0 ) {
						length = 10; // TODO properties (기본 페이지 당 row 수)
					}
					
					PageHelper.startPage(start, length);					
				}
			}
			
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			// ignore
		}
		
	}
}
