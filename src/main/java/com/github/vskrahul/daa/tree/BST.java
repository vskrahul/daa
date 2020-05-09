package com.github.vskrahul.daa.tree;

public class BST<V extends Comparable<V>> {

	private Node<V> root;
	
	public boolean insert(V value) {
		
		Node<V> node = new Node<>(value);
		Node<V> temp = this.root;
		
		if(temp == null) {
			this.root = node;
			return true;
		}
		
		while(true) {
			if(node.getValue().compareTo(temp.getValue()) < 0) {
				if(temp.getLeft() == null) {
					temp.setLeft(node);
					node.setParent(temp);
					return true;
				}
				temp = temp.getLeft();
			} else {
				if(node.getValue().compareTo(temp.getValue()) > 0) {
					if(temp.getRight() == null) {
						temp.setRight(node);
						node.setParent(temp);
						return true;
					}
					temp = temp.getRight();
				} else {
					return false;
				}
			}
		}
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
		return null;
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
		return node.getParent().getLeft().getValue().equals(node.getValue());
	}
	
	private boolean isRightNode(Node<V> node) {
		return node.getParent().getRight().getValue().equals(node.getValue());
	}
}
