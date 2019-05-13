package com.microsoft.interview;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueueTest {

	public static void main(String[] args)
	{
		Queue<Integer> queue1 = new LinkedList<Integer>();
		int count = 7;
		int start = 0;
		int max = -1;
		queue1.add(6);
		queue1.add(1);
		queue1.add(3);
		queue1.add(2);
		queue1.add(4);
		queue1.add(7);
		queue1.add(5);
		Queue<Integer> queue2 = new LinkedList<Integer>();
		/*
		 * 1. Keep dequeueing from the first queue.
		 * 		If
		 * 
		 */
		while(start<count)
		{
			max = -1;
			int index = count-start;
			for(int i=0;i<index;i++)
			{
				int temp = queue1.remove();
				if(temp > max)
				{
					if(max!=-1)
						queue2.add(max);
					max = temp;
				}
				else
				{
					queue2.add(temp);
				}
			}
			queue2.add(max);
			if(index<count)
				for(int i=index;i<count;i++)
				{
					int temp = queue1.remove();
					queue2.add(temp);
				}
			Queue<Integer> tempQ = queue1;
			queue1 = queue2;
			//queue2 = new LinkedList<Integer>();
			queue2 = tempQ;
			start++;
		}
		
		System.out.println(queue1.size());
		while(!queue1.isEmpty())
			System.out.print(queue1.remove()+" ");
	}
}
