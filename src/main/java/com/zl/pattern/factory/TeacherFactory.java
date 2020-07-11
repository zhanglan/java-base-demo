package com.zl.pattern.factory;

import com.zl.pattern.factory.bean.IPerson;
import com.zl.pattern.factory.bean.Teacher;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class TeacherFactory implements IPersonFactory {
	@Override
	public IPerson create() {
		return new Teacher();
	}
}
