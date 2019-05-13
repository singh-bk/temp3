package com.concurrent.www;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest2 {

	public static void main(String[] args) {
		ImmutableNode node = new ImmutableNode(12, "BK", 12);
		AtomicReference<ImmutableNode> atomic = new AtomicReference<ImmutableNode>(node);
		ImmutableNode updatedNode = new ImmutableNode(12, "BK", 33);
		atomic.compareAndSet(node, updatedNode);
		
		System.out.println(node.getAge());
		node = atomic.get();
		System.out.println(node.getAge());
		
		ImmutableNode nullNode = null;
		AtomicReference<ImmutableNode> nullAtomic = new AtomicReference<ImmutableNode>(nullNode);
		nullAtomic.compareAndSet(nullNode, node);
		System.out.println(nullAtomic.get().getAge());
	}
}
