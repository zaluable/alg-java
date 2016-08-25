package ArrayTest;

import java.util.Iterator;

import org.testng.annotations.Test;

public class QueueSimuWithNode<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	public class Node{
		Item item;
		Node next;
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public void enqueue(Item item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		N++;
	}
	public Item dequeue(){
		Item oldItem = first.item;
		first = first.next;
		if (isEmpty()){
			last = null;
		}
		N--;
		return oldItem;
	}
	public Iterator<Item> iterator(){
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<Item>{
		private Node currcent = first;
		public boolean hasNext(){
			return currcent != null ;
		}
		public Item next(){
			Item itemTemp = currcent.item;
			currcent = currcent.next;
			return itemTemp;
		}
//		public Item remove(){
//			
//		}
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	@Test
	public void testQueueSimuWithNode(){
		String[] testStr = {"to","be","-","not"};
		QueueSimuWithNode<String> queueSimuWithNode = new QueueSimuWithNode<String>();
		for (int i = 0 ; i < testStr.length ; i++){
			if (testStr[i].equals("-")){
				System.out.println("delete:"+queueSimuWithNode.dequeue());
			}else{
				queueSimuWithNode.enqueue(testStr[i]);
			}
			Iterator<String> it = queueSimuWithNode.iterator();
			System.out.print("elements are:");
			while (it.hasNext()){
				String str = it.next();
				System.out.println(str+" ");
			}
		}
	}
}
