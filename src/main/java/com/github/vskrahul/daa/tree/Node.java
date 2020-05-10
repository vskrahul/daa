package com.github.vskrahul.daa.tree;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@ToString(of={"value"})
class Node<V extends Comparable<V>> {

	private V value;
	
	private Node<V> parent;
	
	private Node<V> left;
	
	private Node<V> right;
	
	public Node(V value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Node) {
			Node n = (Node)obj;
			return this.value.equals(n.getValue());
		}
		return false;
	}
}