package com.github.vskrahul.daa.sort;

import static com.github.vskrahul.daa.utils.HeapUtils.buildMaxHeap;
import static com.github.vskrahul.daa.utils.HeapUtils.buildMinHeap;
import static com.github.vskrahul.daa.utils.HeapUtils.maxHeapify;
import static com.github.vskrahul.daa.utils.HeapUtils.minHeapify;

public class PriorityQueue<T extends Comparable<T>> {

	private T[] arr;
	
	private int heapSize;
	
	private boolean max;
	
	private Object lock = new Object();
	
	public PriorityQueue(T[] arr, boolean max) {
		this.arr = arr;
		this.heapSize = arr.length;
		this.max = max;
		if(max)
			buildMaxHeap(arr);
		else
			buildMinHeap(arr);
	}
	
	public T extract() {
		T result = null;
		
		synchronized (lock) {
			
			if(this.heapSize < 0)
				throw new RuntimeException("NOT FOUND!");
			
			result = arr[0];
			arr[0] = arr[heapSize - 1];
			this.heapSize--;
			if(max)
				maxHeapify(arr, heapSize, 0);
			else
				minHeapify(arr, heapSize, 0);
		}
		return result;
	}
	
	public T peak() {
		return arr[0];
	}
}