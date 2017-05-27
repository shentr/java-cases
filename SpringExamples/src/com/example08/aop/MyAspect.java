package com.example08.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	// 声明一个可以复用的切入点
	@Pointcut("execution(* com.example08..*.*(..))")
	public void pointcut() {
	}
	@Before("pointcut()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice");
	}
	@AfterReturning(("pointcut()"))
	public void afterRunningAdvice() {
		System.out.println("afterReturningAdvice");
	}
	@After(("pointcut()"))
	public void afterAdvice() {
		System.out.println("afterAdvice");
	}
	@Around(("pointcut()"))
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("before aroundAdvice");
		Object object = joinPoint.proceed();
		System.out.println("after aroundAdvice");
		return object;
	}
}
