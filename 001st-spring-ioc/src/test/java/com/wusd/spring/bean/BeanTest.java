package com.wusd.spring.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wusd
 * @date 2020/1/3 16:32
 */
public class BeanTest {
	@Test
	public void testStu() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		Student student = applicationContext.getBean("student", Student.class);
		System.out.println("student: " + student);
	}

}
