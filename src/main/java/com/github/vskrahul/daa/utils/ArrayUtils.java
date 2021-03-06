package com.github.vskrahul.daa.utils;

import java.util.Arrays;

public class ArrayUtils {

	public static <T> void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static <T> void print(T[] array, boolean flag) {
		if(flag)
			System.out.println(Arrays.toString(array));
	}
}