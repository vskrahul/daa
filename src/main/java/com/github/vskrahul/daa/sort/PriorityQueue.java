package com.github.vskrahul.daa.sort;

import static com.github.vskrahul.daa.utils.HeapUtils.buildMaxHeap;
import static com.github.vskrahul.daa.utils.HeapUtils.buildMinHeap;
import static com.github.vskrahul.daa.utils.HeapUtils.maxHeapify;

import com.github.vskrahul.daa.utils.ArrayUtils;

import static com.github.vskrahul.daa.utils.HeapUtils.*;

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
	
	public void insert(T t) {
		
		synchronized (lock) {
			if(this.heapSize == this.arr.length) {
				throw new RuntimeException("Not Enough Space!-");
			}
			
			this.heapSize++;
			this.arr[this.heapSize - 1] = t;
			int i = this.heapSize - 1;
			boolean flag = max ? this.arr[parent(i)].compareTo(this.arr[i]) < 0 
								: this.arr[parent(i)].compareTo(this.arr[i]) > 0;
			while(i > 0 && flag) {
				ArrayUtils.swap(arr, parent(i), i);
				i = parent(i);
			}
		}
		
	}
	
	public T peak() {
		return arr[0];
	}
}