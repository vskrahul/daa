package com.github.vskrahul.daa;

import com.github.vskrahul.daa.tree.BST;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		//Integer[] array = {1, 4, 5, 10, 16, 17, 21};
		int[] array = {10, 4, 17, 1, 5, 16, 21};
		
		BST<Integer> bst = new BST<>();
		
		for(int i : array) {
			bst.insert(i);
		}	
		bst.inOrder();
		
		for(int i : array) {
			System.out.println(bst.search(i));
		}
		
		System.out.println("minimum = " + bst.minimum());
		System.out.println("maximum = " + bst.maximum());
		System.out.println("successor of 5 = " + bst.successor(5));
		System.out.println("successor of 16 = " + bst.successor(16));
	}
}