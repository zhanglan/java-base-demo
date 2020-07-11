package com.zl.algo.recursion;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/23
 */
public class FibonacciTest {

	private Map<Integer, BigInteger> cache = new HashMap<>();

	public BigInteger getFibonacciNum(int n) {
		if (n <= 2) {
			return new BigInteger("1");
		} else {
			if (cache.containsKey(n)) {
				return cache.get(n);
			}
			cache.put(n, getFibonacciNum(n-1).add(getFibonacciNum(n-2)));
			return cache.get(n);
		}
	}

	public BigInteger fab(int n, BigInteger pre, BigInteger res) {
		if (n <= 2) return res;
		return fab(n-1, pre, pre.add(res));
	}

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		FibonacciTest fib = new FibonacciTest();
		System.out.println(fib.getFibonacciNum(2000).toString());
		long t2 = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis()-t1);
		System.out.println(fib.fab(2000, BigInteger.ONE, BigInteger.ONE).toString());
		System.out.println(System.currentTimeMillis()-t2);
	}

}
