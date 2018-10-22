package com.company.hellospring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //빈 등록과 같은 기능.
@Aspect	 // aop:aspectj-autoproxy 검색 (어드바이스 클래스와 포인트 컷을 결합 해놓은것)
public class BeforeAdvice {
		//포인트 컷
		@Pointcut("execution(* com.company..*Imp1.*(..))") //aop 포인트컷 설정
		public void allpointcut(){}
		
		@Pointcut("execution(* com.company..*Imp1.get*(..))")
		public void getpointcut(){}
		
		@Before("allpointcut()")			//aspect 설정 부분 포인트 컷 중에서 무엇을 불러쓸지 설정함
		public void beforeLog(JoinPoint jp) {
		
		
		String methodName =jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String argsStr = args != null && args.length>0? args[0].toString() : "";
		System.out.println("[사전처리]" +methodName+ " : " + argsStr);
	}
}