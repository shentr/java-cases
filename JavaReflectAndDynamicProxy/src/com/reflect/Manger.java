package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Manger {

	public Manger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class<?> userClass = Class.forName("com.reflect.User");
		
		for (Field field : userClass.getDeclaredFields()) {
			System.out.println(field.getName());
			System.out.println(field.getType().getName());
		}
		
		for (Method method : userClass.getDeclaredMethods()) {
			System.out.println(method.getName());
		}

		Method setName = userClass.getDeclaredMethod("setName", String.class);
		Method getName = userClass.getDeclaredMethod("getName");
		Method setId = userClass.getDeclaredMethod("setId", int.class);
		Method getId = userClass.getDeclaredMethod("getId");
		Object user = userClass.newInstance();
		setName.invoke(user, "BO");
		setId.invoke(user, 1);
		System.out.println(getId.invoke(user));
		System.out.println(getName.invoke(user));
		
	}

}
