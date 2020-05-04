/**
 * 
 */
package com.github.vskrahul.daaa.sort;

import static com.github.vskrahul.daaa.utils.ArrayUtils.print;

/**
 * @author Rahul Vishvakarma
 *
 */
public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] array) {
		print(array);
		execute(array);
		print(array);
	}
	
	abstract protected void execute(T[] array);
}
