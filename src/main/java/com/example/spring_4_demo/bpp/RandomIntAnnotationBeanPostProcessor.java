package com.example.spring_4_demo.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author akimov
 * created at 14.11.2020 12:23
 */
@Component
public class RandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

	private final Random rnd;

	public RandomIntAnnotationBeanPostProcessor() {
		rnd = new Random(0);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		final Field[] fields = bean.getClass().getDeclaredFields();

		for (Field field : fields) {
			InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
			if (annotation != null && field.getType().equals(int.class)) {
				final int min = annotation.min();
				final int max = annotation.max();
				int i = rnd.ints(min, (max + 1)).findFirst().getAsInt();
				field.setAccessible(true);
				ReflectionUtils.setField(field, bean, i);
			}
		}
		return bean;
	}
}
