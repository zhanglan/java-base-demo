package com.zl.pattern.factory;

import com.zl.pattern.factory.bean.IPerson;
import com.zl.pattern.factory.bean.Student;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class StudentFactory implements IPersonFactory {
	@Override
	public IPerson create() {
		return new Student();
	}
}
