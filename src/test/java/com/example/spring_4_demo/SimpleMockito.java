package com.example.spring_4_demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author akimov
 * created at 19.12.2020 10:22
 */
@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class SimpleMockito {

	@Mock
	List mockedList;

	@Test
	void mockitoVerify() {
		mockedList.add("one");
		mockedList.clear();

		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	@Test
	void mockitoStubbing() {
		when(mockedList.get(0)).thenReturn("first");

		// the following prints "first"
		System.out.println(mockedList.get(0));

		// the following prints "null" because get(999) was not stubbed
		System.out.println(mockedList.get(999));
	}

	@Test
	public void testSpy() {

//		BDDMockito.mock()
		List<String> list = spy(new ArrayList<>());
		Mockito.doReturn("first 1").when(list).get(eq(0));
//		when(list.get(eq(0))).thenReturn("first 1");

		// вызов метода реального класса
		list.get(0);

		// проверка вызова метода
		verify(list).get(0);

		// проверка возвращаемого методом значения
		assertEquals("first 1", list.get(0), "0");
		// проверка вызова метода не менее 2-х раз
		verify(list, atLeast(2)).get(0);
	}

}
