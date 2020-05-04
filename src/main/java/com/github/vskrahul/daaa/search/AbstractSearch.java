package com.github.vskrahul.daaa.search;

import com.github.vskrahul.daaa.utils.ArrayUtils;

public abstract class AbstractSearch<T extends Comparable<T>> implements Search<T> {
	
	private boolean trace = false;
	
	public AbstractSearch() {
		
	}
	
	public AbstractSearch(boolean trace) {
		this.trace = trace;
	}

	@Override
	public int search(T[] array, T element) {
		ArrayUtils.print(array, trace);
		int idx = execute(array, element);
		if(trace)
			System.out.println(String.format("A[%d] = %s", idx, element));
		return idx;
	}
	
	protected abstract int execute(T[] array, T element);
}