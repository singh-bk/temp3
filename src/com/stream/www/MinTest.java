package com.stream.www;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinTest {

	public static void main(String[] args) {
		Node node = new Node(1, "as", 12);
		Node node1 = new Node(2, "aas", 21);
		Node node2 = new Node(3, "as", 7);
		Node node3 = new Node(4, "as", 13);
		Node node4 = new Node(5, "as", 9);
		Node node5 = new Node(6, "as", 5);
		Node node6 = new Node(7, "as", 23);
		Node node7 = new Node(8, "as", 12);
		Node node8 = new Node(9, "as", 11);
		
		List<Node> list = new ArrayList<Node>();
		list.add(node);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		list.add(node6);
		list.add(node7);
		list.add(node8);
		
		System.out.println(list.stream().max(Comparator.comparing(Node::getName)).get().getAge());
	}
}
