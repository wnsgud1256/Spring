package com.company.hellospring.common;

public class LogAdvice {			//공통 업무
	public void pringLog() {
		System.out.println("[공통로그 비즈니스 로직 수행전 동작]");// 현업에서는 쓸모없는 로그가 많이찍히는걸 싫어한다.
	}
}
