package com.zl.algo.sort;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/24
 */
public class InsertSort {

	public static int[] sort(int[] array) {
		int[] result = new int[array.length];
		result[0] = array[0];
		int len = array.length;
		for (int i = 1; i < len; i++) {
			int data = array[i];
			for (int j = i-1; j >= 0 ; j--) {
				if (data < result[j]) {
					result[j+1] = result[j];
					result[j] = data;
				} else {
					result[j+1] = data;
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = {3, 4, 1, 7, 9, 2, 5};
		int[] res = sort(arr);
		for (int var: res) {
			System.out.println(var);
		}
	}


}
