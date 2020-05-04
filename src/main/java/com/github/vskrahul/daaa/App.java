package com.github.vskrahul.daaa;

import com.github.vskrahul.daaa.sorting.*;
import com.github.vskrahul.daaa.sorting.Sorting;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Sorting<Integer> sort = new InsertionSort<>();
		sort.sort(new Integer[]{2,4,5,7,1,2,3,6});
	}
}