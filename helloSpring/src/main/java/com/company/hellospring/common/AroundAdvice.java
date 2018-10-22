package com.company.hellospring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

	@Around("BeforeAdvice.allpointcut()")
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(methodName + "메소드 수행에 걸린 시간 :" + stopWatch.getTotalTimeMillis() + "(ms)초"); //1000 1초  / 0초 이하일때는 1000.0으로 소수점을 표시해주지 않으면 0초만뜸.
		return obj;
		
	}
}
