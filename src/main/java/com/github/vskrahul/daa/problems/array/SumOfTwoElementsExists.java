package com.github.vskrahul.daa.problems.array;

import com.github.vskrahul.daa.search.BinarySearch;
import com.github.vskrahul.daa.search.Search;
import com.github.vskrahul.daa.sort.MergeSort;
import com.github.vskrahul.daa.sort.Sort;

public class SumOfTwoElementsExists {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 2, 3, 4, 5, 6, 7};
		int X = 13;
		
		Sort<Integer> sort = new MergeSort<>();
		Search<Integer> search = new BinarySearch<>();
		
		sort.sort(arr);
		int idx = -1;
		int i = 0;
		
		while(i < arr.length - 1) {
			idx = search.search(arr, X - arr[i]);
			if(idx != -1)
				break;
			i++;
		}
		if(idx != -1)
			System.out.println(String.format("A[%d] + A[%d] = %d", i, idx, arr[i] + arr[idx]));
		else
			System.out.println("NOT EXISTS");
	}
}
