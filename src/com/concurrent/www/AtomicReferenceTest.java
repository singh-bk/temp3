package com.concurrent.www;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class AtomicReferenceTest {

	static public ImmutableNode node = new ImmutableNode(1, "BK", 33);
	public static AtomicReference<ImmutableNode> atomic = new AtomicReference<ImmutableNode>(
			node);

	public static AtomicReference<ImmutableNode> GetReference() {
		return atomic;
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(4);
		List<Future<ImmutableNode>> futures = new ArrayList<Future<ImmutableNode>>();
		int seed = 0;

		IntStream.iterate(seed, i -> i + 1).limit(4)
				.forEach(r -> futures.add(service.submit(new CallableImpl())));

		service.shutdown();
		IntStream.iterate(seed, i -> i + 1).limit(4)
				.forEach(r -> futures.get(r));

		System.out.println(atomic.get().getAge());
		System.out.println(node.getAge());
		node = atomic.get();
		System.out.println(node.getAge());
		service.shutdown();
	}
}

class CallableImpl implements Callable<ImmutableNode> {

	@Override
	public ImmutableNode call() throws Exception {
		AtomicReference<ImmutableNode> atomic = AtomicReferenceTest
				.GetReference();
		ImmutableNode node = atomic.get();
		ImmutableNode node2 = new ImmutableNode(1, "BK", node.getAge() + 1);
		while (!atomic.compareAndSet(node, node2)) {
			node2 = new ImmutableNode(1, "BK", node.getAge() + 1);
		}
		// System.out.println("Thread:" + Thread.currentThread().getName()
		// + " age:" + node2.getAge());
		return node2;
	}

}
