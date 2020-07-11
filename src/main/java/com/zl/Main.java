package com.zl;

import com.zl.bean.Person;
import com.zl.config.MainConfig;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/22
 */
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
//		Person person = ctx.getBean("person", Person.class);
//		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean_factory_test.xml"));
//		Person person = beanFactory.getBean("person", Person.class);
//		System.out.println(person);
//		System.out.println(person);
	}

}
