package com.github.vskrahul.daa.sort;

import static com.github.vskrahul.daa.utils.ArrayUtils.swap;
import static com.github.vskrahul.daa.utils.HeapUtils.buildMaxHeap;
import static com.github.vskrahul.daa.utils.HeapUtils.maxHeapify;

public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {

	public HeapSort(boolean trace) {
		super(trace);
	}
	
	@Override
	protected void execute(T[] array) {
		int heap_size = array.length;
		buildMaxHeap(array);
		for(int i = array.length - 1; i >= 1; i--) {
			swap(array, 0, i);
			heap_size--;
			maxHeapify(array, heap_size, 0);
		}
	}
}