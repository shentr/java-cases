package com.dynamic.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	public MyInvocationHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(new Date());
		Object object = arg1.invoke(target, arg2);
		System.out.println(arg0.getClass().getName());
		return object;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
