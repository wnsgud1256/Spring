package com.company.hellospring.common;

import org.aspectj.lang.annotation.AfterThrowing;

public class AfterThrowingAdvice {
	
	@AfterThrowing("BeforeAdvice.allpointcut()")
	public void exceptionLog() {
		System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
