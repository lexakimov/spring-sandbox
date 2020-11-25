package com.example.spring_4_demo.bpp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author akimov
 * created at 14.11.2020 12:26
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

	int min();

	int max();
}
