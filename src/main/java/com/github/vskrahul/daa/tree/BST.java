package com.github.vskrahul.daa.tree;

import java.util.Stack;

public class BST<V extends Comparable<V>> {

	private Node<V> root;
	
	public boolean insert(V value) {
		
		Node<V> node = new Node<>(value);
		Node<V> temp = this.root;
		Node<V> parent = null;
		
		while(temp != null) {
			parent = temp;
			if(node.getValue().compareTo(temp.getValue()) < 0) {
				temp = temp.getLeft();
			} else {
				if(node.getValue().compareTo(temp.getValue()) > 0) {
					temp = temp.getRight();
				} else {
					return false;
				}
			}
		}
		if(parent == null) { // tree was empty
			this.root = node;
		} else {
			if(parent.getValue().compareTo(node.getValue()) > 0) {
				parent.setLeft(node);
			} else {
				parent.setRight(node);
			}
			node.setParent(parent);
		}
		
		return true;
	}
	
	/**
	 * <p>
	 * We can use {@code predecessor} or {@code successor} to replace
	 * the deleted node. Both are the valid to replace.
	 * <p>
	 * We are using {@code predecessor} in this example.
	 * @param v value to be deleted
	 */
	public void delete(V v) {
		Node<V> node = searchNode(this.root, v);
		Node<V> predecessor = null;
		
		if(isLeaf(node) || hasOneChild(node)) {
			if(isRightNode(node))
				node.getParent().setRight(child(node));
			else
				node.getParent().setLeft(child(node));
		} else {
			predecessor = predecessorNode(node);
			/*
			 * predecessor will be a leaf node,
			 * But that could have LEFT child
			 */
			predecessor.getParent().setRight(predecessor.getLeft());
			if(predecessor.getLeft() != null)
				predecessor.getLeft().setParent(predecessor.getParent());
			
			if(isRightNode(node)) {
				node.getParent().setRight(predecessor);
			} else {
				node.getParent().setLeft(predecessor);
			}
			predecessor.setRight(node.getRight());
			node.getRight().setParent(predecessor);
			
			predecessor.setLeft(node.getLeft());
			node.getLeft().setParent(predecessor);
			
			predecessor.setParent(node.getParent());
		}
		nullify(node);
	}
	
	public boolean search(V value) {
		return search(this.root, value);
	}
	
	public V minimum() {
		return minimum(this.root);
	}
	
	public V maximum() {
		return maximum(this.root);
	}
	
	public V successor(V v) {
		Node<V> node = searchNode(this.root, v);
		return successor(node);
	}
	
	public V predecessor(V v) {
		Node<V> node = searchNode(this.root, v);
		return predecessor(node);
	}
	
	public void inOrder() {
		if(this.root == null)
			return;
		inOrder(this.root);
		System.out.print("\n");
	}
	
	public void preOrder() {
		if(this.root == null)
			return;
		preOrder(this.root);
		System.out.print("\n");
	}
	
	public void postOrder() {
		if(this.root == null)
			return;
		postOrder(this.root);
		System.out.print("\n");
	}
	
	private V successor(Node<V> node) {
		if(node.getRight() != null)
			return minimum(node.getRight());
		
		Node<V> temp = node.getParent();
		
		while(temp != null && isRightNode(node)) {
			node = temp;
			temp = temp.getParent();
		}
		
		return temp.getValue();
	}
	
	private V predecessor(Node<V> node) {
		
		if(node.getLeft() != null)
			return maximum(node.getLeft());
		
		Node<V> temp = node.getParent();
		
		while(temp != null && isLeftNode(node)) {
			node = temp;
			temp = temp.getParent();
		}
		
		return temp.getValue();
	}
	
	private Node<V> predecessorNode(Node<V> node) {
		
		if(node.getLeft() != null)
			return maximumNode(node.getLeft());
		
		Node<V> temp = node.getParent();
		
		while(temp != null && isLeftNode(node)) {
			node = temp;
			temp = temp.getParent();
		}
		
		return temp;
	}
	
	private boolean search(Node<V> node, V value) {
		if(node == null)
			return false;
		if(node.getValue().equals(value))
			return true;
		if(node.getValue().compareTo(value) > 0) {
			return search(node.getLeft(), value);
		}
		return search(node.getRight(), value);
	}
	
	private Node<V> searchNode(Node<V> node, V value) {
		if(node == null)
			return null;
		if(node.getValue().equals(value))
			return node;
		if(node.getValue().compareTo(value) > 0) {
			return searchNode(node.getLeft(), value);
		}
		return searchNode(node.getRight(), value);
	}
	
	private V minimum(Node<V> node) {
		if(node.getLeft() != null) {
			return minimum(node.getLeft());
		}
		return node.getValue();
	}
	
	private V maximum(Node<V> node) {
		if(node.getRight() != null) {
			return maximum(node.getRight());
		}
		return node.getValue();
	}
	
	private Node<V> maximumNode(Node<V> node) {
		if(node.getRight() != null) {
			return maximumNode(node.getRight());
		}
		return node;
	}
	
	private void inOrder(Node<V> node) {
		if(node == null)
			return;
		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}
	
	private void preOrder(Node<V> node) {
		if(node == null)
			return;
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}
	
	private void postOrder(Node<V> node) {
		if(node == null)
			return;
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}
	
	private boolean isLeftNode(Node<V> node) {
		if(node.getParent() == null)
			return false;
		return node.equals(node.getParent().getLeft());
	}
	
	private boolean isRightNode(Node<V> node) {
		if(node.getParent() == null)
			return false;
		return node.equals(node.getParent().getRight());
	}
	
	private boolean isLeaf(Node<V> node) {
		return node != null && node.getRight() == null && node.getLeft() == null;
	}
	
	private boolean hasOneChild(Node<V> node) {
		if(node == null)
			return false;
		return (node.getLeft() != null && node.getRight() == null)
				||
				(node.getLeft() == null && node.getRight() != null);
	}
	
	private Node<V> child(Node<V> node) {
		Node<V> child = null;
		if(hasOneChild(node))
			child = node.getLeft() == null ? node.getRight() : node.getLeft();
		return child;
	}
	
	private void nullify(Node<V> node) {
		node.setLeft(null);
		node.setRight(null);
		node.setParent(null);
	}
	
	public void print() {
		
		Stack<Node<V>> stack1 = new Stack<>();
		Stack<Node<V>> stack2 = new Stack<>();
		
		stack1.push(this.root);
		
		while(!stack1.empty()) {
			Node<V> node = stack1.pop();
			if(node.getLeft() != null) stack2.push(node.getLeft());
			if(node.getRight() != null) stack2.push(node.getRight());
			System.out.print(node.getValue() + " ");
			
			if(stack1.empty()) {
				while(!stack2.empty()) {
					stack1.push(stack2.pop());
				}
				System.out.print("\n");
			}
		}
	}
}
