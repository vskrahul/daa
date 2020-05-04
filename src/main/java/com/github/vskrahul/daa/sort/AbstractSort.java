package com.github.vskrahul.daa.sort;

import static com.github.vskrahul.daa.utils.ArrayUtils.print;

/**
 * @author Rahul Vishvakarma
 *
 */
public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {

	private boolean trace = false;
	
	public AbstractSort() {
		
	}
	
	public AbstractSort(boolean trace) {
		this.trace = trace;
	}
	
	@Override
	public void sort(T[] array) {
		print(array, trace);
		execute(array);
		print(array, trace);
	}
	
	abstract protected void execute(T[] array);
}
