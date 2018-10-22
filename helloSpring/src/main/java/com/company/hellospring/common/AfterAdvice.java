package com.company.hellospring.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@After("BeforeAdvice.allpointcut()")
	public void finalyLog() {
		System.out.println("[사후처리] 무조건 실행");
	}
}
