package com.zl.pattern.factory;

import com.zl.pattern.factory.bean.IPerson;
import com.zl.pattern.factory.bean.Student;
import com.zl.pattern.factory.bean.Teacher;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class SimpleFactory {

	public static IPerson create(String type) {
		switch (type) {
			case "teacher":
				return new Teacher();
			case "student":
				return new Student();
			default:
				return null;
		}
	}

}
