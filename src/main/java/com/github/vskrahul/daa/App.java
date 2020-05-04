package com.github.vskrahul.daa;

import com.github.vskrahul.daa.search.BinarySearch;
import com.github.vskrahul.daa.search.Search;

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