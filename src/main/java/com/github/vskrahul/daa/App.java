package com.github.vskrahul.daa;

import com.github.vskrahul.daa.sort.PriorityQueue;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Integer[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(array, true);
		
		System.out.println(queue.peak());
		
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
		System.out.println(queue.extract());
	}
}