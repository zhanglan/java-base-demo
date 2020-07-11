package com.zl.collection;

import java.util.*;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/12
 */
public class ArrayListTest {

	public static void main(String[] args) {
		int h = "key".hashCode();
		System.out.println("h = " + h);
		System.out.println(Integer.toBinaryString(h));
		int hash = h ^ (h >>> 16);
		System.out.println(h>>>16);
		System.out.println("hash = " + hash);


	}



}
