package com.github.vskrahul.daaa.utils;

public class ArrayUtils {

	public static <T> void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}