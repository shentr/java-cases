package com.example09.aopadvanced;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example09.aopadvanced.MyAuthority.MyAuthorityType;


@Component
@Aspect
public class MyAspect {
	// @Around("within(com.example09.aopadvanced.*) && @annotation(MyAuthority)")
	// @Around("@annotation(com.example09.aopadvanced.MyAuthority)")
	// @Around("@within(com.example09.aopadvanced.MyAuthority)")
	// @Around("execution(* com.example09.aopadvanced.impl.*.*(..))")
	// @Around("@within(com.example09.aopadvanced.MyAuthority)")
	// @Around("within(com.example09.aopadvanced..*) && @within(myAuthority)")
	// @Around("@target(com.example09.aopadvanced.MyAuthority)")
	// @Around("@annotation(myAuthority)")
	
	// 任何包含MyAuthority注释的类或方法，顺序必须是先判断方法再判断类型
	@Around(value = "@within(myAuthority) || @annotation(myAuthority)")  
	public Object interecptorTarget(ProceedingJoinPoint joinpoint, MyAuthority myAuthority) throws Throwable {
		// 如果是类型注释
		if (myAuthority == null) {
			// 类型注释@annotation(myAuthority)会将myAuthority参数至空，因此需反射获取类注释
			myAuthority =  joinpoint.getTarget().getClass().getAnnotation(MyAuthority.class);
		}
		for (MyAuthorityType t : myAuthority.value()) {
			// 比较用户实际权限
			System.out.println(t);
		}
		return joinpoint.proceed();
	}
	
	// 获取get()执行时间
	/*@Around("execution(* com.example09.aopadvanced.AOPService.get(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		long startTime = System.nanoTime();
		Object object = joinpoint.proceed();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		return object;
	}*/
	
	
	/*@Around("within(com.example09.aopadvanced..*)")
	public Object aroundAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("Target Type" + joinpoint.getTarget().getClass());
		System.out.println("Method Name: " + joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();
		for (Object arg : args) {
			System.out.println("arg: " + arg);
		}
		args[0] = "SUN";
		// 替换参数
		return joinpoint.proceed(args);
	}*/
}
