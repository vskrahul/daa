package com.github.vskrahul.daaa;

import com.github.vskrahul.daaa.search.BinarySearch;
import com.github.vskrahul.daaa.search.Search;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Integer[] arr = {1, 2, 2, 3, 4, 5, 6, 7};
		
		Search<Integer> search = new BinarySearch<>();
		search.search(arr, 5);
	}
}