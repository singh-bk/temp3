package com.video.www;

public class CustomListImpl<T> implements CustomList<T> {

	ListNode<T> head = new ListNode<T>();
	
	/**
	 * Default Constructor.
	 * Do not initialize head.
	 */
	public CustomListImpl(){
		
	}
	
	/**
	 * Constructor to create a LinkedList with the header as t
	 * @param t
	 */
	public CustomListImpl(T t){
		this.head = new ListNode<T>(t);
	}
	
	/* (non-Javadoc)
	 * @see com.video.www.CustomList#add(java.lang.Object)
	 */
	@Override
	public void add(T t) {
		if(this.head.getElement() == null){
			this.head = new ListNode<T>(t);
		}
		else{
			ListNode<T> current = this.head;
			ListNode<T> next = this.head.getNextElement();
			while(next != null){
				current = next;
				next = next.getNextElement();
			}
			ListNode<T> node = new ListNode<T>(t);
			current.setNextElement(node);
		}
	}
	
	/**
	 * Method to print the list
	 */
	public void PrintList(){
		if(this.head.getElement() == null){
			System.out.println("The list is empty");
		}
		else{
			System.out.print("The Elements of the list are:");
			ListNode<T> current = this.head;
			while(current != null){
				System.out.print(current.getElement()+" ");
				current = current.getNextElement();
			}
		}
	}

}
