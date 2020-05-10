package com.github.vskrahul.daa;

import com.github.vskrahul.daa.tree.BST;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		int[] arr = {10, 4, 17, 2, 8, 12, 22, 1, 3, 7, 9, 11, 14, 20, 24, 6, 13, 19, 21, 23, 26};
		//int[] arr = {10, 4, 17, 1, 5, 16, 21};
		
		BST<Integer> bst = new BST<>();
		
		for(int i : arr) {
			bst.insert(i);
		}	
		bst.print();
		System.out.println("========================================");
		bst.delete(17);
		bst.print();
	}
}