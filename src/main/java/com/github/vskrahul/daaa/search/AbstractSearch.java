package com.github.vskrahul.daaa.search;

import com.github.vskrahul.daaa.utils.ArrayUtils;

public abstract class AbstractSearch<T extends Comparable<T>> implements Search<T> {

	@Override
	public int search(T[] array, T element) {
		ArrayUtils.print(array);
		int idx = execute(array, element);
		System.out.println(String.format("A[%d] = %s", idx, array[idx]));
		return idx;
	}
	
	protected abstract int execute(T[] array, T element);
}