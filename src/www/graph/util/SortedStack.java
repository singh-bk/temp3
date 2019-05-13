package www.graph.util;

import java.util.Stack;


public class SortedStack extends Stack<Integer>{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 1. Check the last element on the stack via peek
	 * 2. if the elem is null or is less than the new num
	 * 		add the new num to the stack
	 * 3. else
	 * 		pop the elem and push it on a new stack
	 * 4. repeat 1-2-3 while you put the new num on the stack
	 * 5. pop elems from new stack and push on the stack
	 * @param num
	 */
	public void sortedPush(int num){
		if(!this.isEmpty())
		{
			Stack<Integer> stack = new Stack<Integer>();
			Integer temp = this.peek();
			while(temp != null && temp > num){
				temp = this.pop();
				stack.push(temp);
				if(!this.isEmpty()){
					temp = this.peek();
				}
				else
				{
					temp = null;
				}
			}
			this.push(num);
			while(!stack.isEmpty()){
				temp = stack.pop();
				this.push(temp);
			}
		}
		else{
			this.push(num);
		}
	}
}
