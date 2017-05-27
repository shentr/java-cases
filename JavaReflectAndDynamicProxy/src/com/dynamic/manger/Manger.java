package com.dynamic.manger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import com.dynamic.handler.MyInvocationHandler;
import com.dynamic.service.UserService;
import com.dynamic.service.impl.UserServiceImpl;

public class Manger {

	public Manger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		// 基于reflect动态获取接口及实现类的类型
		String userServiceString = "com.dynamic.service.UserService";
		String userServiceImplString = "com.dynamic.service.impl.UserServiceImpl";
		Class<?> userServiceClass = Class.forName(userServiceString);
		Class<?> userServiceImplClass = Class.forName(userServiceImplString);
		System.out.println(userServiceClass.isInterface());
		// 判断切入点匹配的是否是interface类型
		if (!userServiceClass.isInterface()) {
			return;
		}
		// 返回类所有实现的接口，判断是否实现类指定接口。基于全限定名判断
		/*for (Class<?> clazz : userServiceImplClass.getInterfaces()) {
			if (!clazz.getTypeName().equals(userServiceString)) {
				return;
			}
		}*/
		// 动态生成接口实现类实例
		Object userServiceImplObject = userServiceImplClass.newInstance();
		// 动态判断该实例是否实现类指定接口。基于动态
		if (!userServiceClass.isInstance(userServiceImplObject)) {
			return;
		}
		// 动态获取接口代理类
		Object proxyObject = Proxy.newProxyInstance(
				Manger.class.getClassLoader(),
				new Class[] { userServiceClass }, new MyInvocationHandler(userServiceImplObject));
		// 基于reflect动态调用指定接口代理类中的方法
		for (Method method : userServiceClass.getDeclaredMethods()) {
			method.invoke(proxyObject, "BO");
			// 没有基于代理类，仅基于reflect的结果，没有打印出日期
			// method.invoke(userServiceImplObject, "BO");
		}
	}
}
