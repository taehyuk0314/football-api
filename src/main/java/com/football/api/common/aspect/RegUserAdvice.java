package com.football.api.common.aspect;

import java.lang.reflect.Method;

import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import com.football.api.security.SecurityUtils;

@Aspect
@Component
public class RegUserAdvice {
	
	@Autowired
	Environment env;
	
	@Before("execution(public * com.football..*Mapper.*(..))")
	public void paging(JoinPoint joinPoint) throws Throwable {
		// 로그인 상태가 아니면 대상 아님
		if (SecurityUtils.getUserDetails() == null) {
			return;
		}

		boolean hasLoginMemNo = true;
		for (Object arg : joinPoint.getArgs()) {
			for (Method method : arg.getClass().getMethods()) {
				switch (method.getName()) {
				case "getLoginMemNo":
						if(arg.getClass().getMethod("getLoginMemNo").invoke(arg) != null) {
							hasLoginMemNo = false;
							continue;
						} else if(arg.getClass().getMethod("getMemNo").invoke(arg) != null) {
							arg.getClass().getMethod("setLoginMemNo").invoke(arg, arg.getClass().getMethod("getMemNo").invoke(arg));
							hasLoginMemNo = false;
							continue;
						}
					break;
				case "setLoginMemNo":
					try {
						if(hasLoginMemNo == false) {
							continue;
						} 
						method.invoke(arg, SecurityUtils.getSimpleUserDetails().getMemNo());
					} catch (Exception e) {
						e.printStackTrace();
						method.invoke(arg, null);
					}
					break;
				}
			}
		}		
	}
}
