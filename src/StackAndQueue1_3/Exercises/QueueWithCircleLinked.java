package StackAndQueue1_3.Exercises;

public class QueueWithCircleLinked<Item> {
	private int N;
	private Node last;
	class Node{
		Item item;
		Node next;		
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public void enqueue(Item item){
		if(isEmpty()){
			
		}
	}
	public Item dequeue(){
		return null;
	}
}
