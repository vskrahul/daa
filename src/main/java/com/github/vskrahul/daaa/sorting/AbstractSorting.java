/**
 * 
 */
package com.github.vskrahul.daaa.sorting;

import java.util.Arrays;

/**
 * @author Rahul Vishvakarma
 *
 */
public abstract class AbstractSorting<T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] array) {
		print(array);
		execute(array);
		print(array);
	}
	
	abstract protected void execute(T[] array);
	
	protected void print(T[] array) {
		System.out.println(Arrays.toString(array));
	}
}
