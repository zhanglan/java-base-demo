package com.zl.pattern.iterator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/23
 */
public class Client {

	public static void main(String[] args) {
		Aggregate<String> aggregate = new ConcreteAggregate<String>();
		aggregate.add("zhangsan");
		aggregate.add("lisi");
		aggregate.add("wangwu");

		Iterator<String> iterator = aggregate.createIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
