package com.github.vskrahul.daaa.utils;

import java.util.Arrays;

public class ArrayUtils {

	public static <T> void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static <T> void print(T[] array) {
		System.out.println(Arrays.toString(array));
	}
}