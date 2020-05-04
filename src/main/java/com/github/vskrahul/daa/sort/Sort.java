/**
 * 
 */
package com.github.vskrahul.daa.sort;

/**
 * @author Rahul Vishvakarma
 *
 */
public interface Sort<T extends Comparable<T>> {

	void sort(T[] array);
}