package com.zl.algo.time;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/17
 */
public class TimeBigO {

	public static void main(String[] args) {
		int a = 1; // O(1)
		for (int i = 0; i < 3; i++) {
			a = a + 1; // O(1)
		}

		int n = Integer.MAX_VALUE;
		int i = 1;
		while (i <= n) {			i = i * 2; // i的值为：1 2 4 8 16 ，计算执行次数x=log2n  复杂度：O(logn)
			i = i * 2;
		}

	}

}
