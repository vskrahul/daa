package com.github.vskrahul.daaa.sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	protected void execute(T[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	private void merge(T[] array, int p, int q,int r) {
		
		int left = q - p + 1;
		int right = r - q;
		
		T[] LEFT = Arrays.copyOfRange(array, p, q + 1);
		T[] RIGHT = Arrays.copyOfRange(array, q + 1, r + 1);
		
		int i = 0;
		int j = 0;
		
		for(int k = p; k <= r; k++) {
			if(i < left && j < right) {
				if(LEFT[i].compareTo(RIGHT[j]) < 0) {
					array[k] = LEFT[i++];
				} else {
					array[k] = RIGHT[j++];
				}
			} else {
				if(i < left)
					array[k] = LEFT[i++];
				else if(j < right)
					array[k] = RIGHT[j++];
			}
		}
	}
	
	private void mergeSort(T[] array, int p, int r) {
		if(p < r) {
			int q = (p + r)/2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}
}