package com.example04.dependsonLazy;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("baseBean")
public class DependsonBean {
	public DependsonBean() {
		System.out.println("DependsonBean");
	}
}
