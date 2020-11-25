package com.example.spring_4_demo.aspects;

import com.example.spring_4_demo.providers.impl.CustomMessageProvider;

/**
 @author akimov
 created at 15.11.2020 11:19
 */
public aspect NewAspect {

	public String CustomMessageProvider.myCall(String name) {
		return "Cognac " + name;
	}

}
