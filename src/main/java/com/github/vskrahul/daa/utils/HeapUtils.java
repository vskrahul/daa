package com.github.vskrahul.daa.utils;

import static com.github.vskrahul.daa.utils.ArrayUtils.swap;

public class HeapUtils {

	public static int maxElementAtHeight(int h) {
		return (1 << (h + 1)) - 1;
	}
	
	public static int minElementAtHeight(int h) {
		return 1 << h;
	}
	
	public static int numberOfLeaves(int n) {
		return (n & 1) == 0 ? n << 2 : (n << 2) + 1;
	}
	
	public static <T extends Comparable<T>> void buildMaxHeap(T[] arr) {
		for(int i = arr.length/2 - 1; i >= 0; i--) {
			maxHeapify(arr, arr.length, i);
		}
	}
	
	public static <T extends Comparable<T>> void buildMinHeap(T[] arr) {
		for(int i = arr.length/2 - 1; i >= 0; i--) {
			minHeapify(arr, arr.length, i);
		}
	}
	
	/**
	 * push the element at given index {@code i} up 
	 * until {@code arr[parent(i)] <= arr[i]} matches.
	 * 
	 * @param arr array
	 * @param i index element to push up
	 */
	public static <T extends Comparable<T>> void minHeapify(T[] arr, int heapSize, int i) {
		int smallest = -1;
		
		final int left = left(i);
		final int right = right(i);
		
		if(left < heapSize && arr[left].compareTo(arr[i]) < 0) {
			smallest = left;
		} else {
			smallest = i;
		}
		
		if(right < heapSize && arr[right].compareTo(arr[smallest]) < 0) {
			smallest = right;
		}
		
		if(smallest != i) {
			swap(arr, smallest, i);
			maxHeapify(arr, heapSize, smallest);
		}	
	}
	
	/**
	 * push the element at given index {@code i} up 
	 * until {@code arr[parent(i)] >= arr[i]} matches.
	 * 
	 * @param arr array
	 * @param i index element to push up
	 */
	public static <T extends Comparable<T>> void maxHeapify(T[] arr, int heapSize, int i) {
		int largest = -1;
		
		final int left = left(i);
		final int right = right(i);
		
		if(left < heapSize && arr[left].compareTo(arr[i]) > 0) {
			largest = left;
		} else {
			largest = i;
		}
		
		if(right < heapSize && arr[right].compareTo(arr[largest]) > 0) {
			largest = right;
		}
		
		if(largest != i) {
			swap(arr, largest, i);
			maxHeapify(arr, heapSize, largest);
		}	
	}
	
	public static boolean isMaxHeap(int[] arr) {
		
		for(int i = 0; i < arr.length/2; i++) {
			if(!isMaxHeap(arr, i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isMinHeap(int[] arr) {
		
		for(int i = 0; i < arr.length/2; i++) {
			if(!isMinHeap(arr, i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isMinHeap(int[] arr, int i) {
		return 2*i < arr.length ? arr[i] <= arr[left(i)]
					: 2*i + 1 < arr.length ? arr[i] <= arr[right(i)] : true;
	}
	
	public static boolean isMaxHeap(int[] arr, int i) {
		return 2*i < arr.length ? arr[i] >= arr[left(i)]
					: 2*i + 1 < arr.length ? arr[i] >= arr[right(i)] : true;
	}
	
	public static int parent(int i) {
		return (i - 1) >> 1;
	}
	
	public static int left(int i) {
		return i == 0 ? 1 : (i << 1) + 1;
	}
	
	public static int right(int i) {
		return i == 0 ? 2 : (i << 1) + 2;
	}
}