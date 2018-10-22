package com.company.hellospring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;


@Service //빈 등록과 같은 기능.
@Aspect	 // aop:aspectj-autoproxy 검색 (어드바이스 클래스와 포인트 컷을 결합 해놓은것)
public class AfterReturningAdvice {
	@AfterReturning(pointcut="BeforeAdvice.allpointcut()",returning="returnObj") //포인트컷 설정:포인트 컷이 어떤건지 명시 해줘야함.
	
public void afterLog(JoinPoint jp, Object returnObj) { //리턴값을 받을려면 두번째 값을 넣어야함
	String methodName = jp.getSignature().getName();
	String returnStr = returnObj != null ? returnObj.toString() : ""; //모든 클래스에 to String 메소드 존재
	System.out.println("[사후처리] " + methodName + " : " + returnStr);
	}
}
