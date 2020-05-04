package com.github.vskrahul.daa.search;

public class BinarySearch<T extends Comparable<T>> extends AbstractSearch<T> {

	public BinarySearch() {
	}
	
	public BinarySearch(boolean trace) {
		super(trace);
	}
	
	@Override
	protected int execute(T[] array, T element) {
		
		int i = 0;
		int min = i;
		int max = array.length - 1;
		
		do {
			if(array[i].equals(element)) {
				return i;
			}
			if(array[i].compareTo(element) < 0) {
				min = i;
			} else {
				if(array[i].compareTo(element) > 0) {
					max = i;
				}
			}
			if(min + 1 == max) { // adjacent
				return array[min].equals(element)
				 ? min
				 : array[max].equals(element) ? max : -1;
			}
			i = (min + max)/2;
		} while(min + 1 != max);
		
		return -1;
	}
}
