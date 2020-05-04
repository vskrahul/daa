package com.github.vskrahul.daaa.sorting;

import static com.github.vskrahul.daaa.utils.ArrayUtils.*;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	protected void execute(T[] array) {
		
		for(int i = 1; i < array.length; i++) {
			
			int j = i;
			while(j > 0 && array[j].compareTo(array[j - 1]) < 0) {
				swap(array, j, j - 1);
				j--;
			}
		}
	}
}