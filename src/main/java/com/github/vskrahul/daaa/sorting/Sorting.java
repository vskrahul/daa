/**
 * 
 */
package com.github.vskrahul.daaa.sorting;

/**
 * @author Rahul Vishvakarma
 *
 */
public interface Sorting<T extends Comparable<T>> {

	void sort(T[] array);
}