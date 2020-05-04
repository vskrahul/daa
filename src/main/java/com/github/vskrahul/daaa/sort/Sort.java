/**
 * 
 */
package com.github.vskrahul.daaa.sort;

/**
 * @author Rahul Vishvakarma
 *
 */
public interface Sort<T extends Comparable<T>> {

	void sort(T[] array);
}