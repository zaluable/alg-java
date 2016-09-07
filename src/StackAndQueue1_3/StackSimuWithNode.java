package StackAndQueue1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;
/**
 * 用单链表实现queue的数据结构，并实现iterator，enqueue，dequeue，size，isEmpty的方法
 * @author xiao
 *
 * @param <Item>
 */
/**
 * @author xiao
 *
 * @param <Item>
 */
public class StackSimuWithNode<Item> implements Iterable<Item>{
	
	private Node<Item> first;   //define the top node of the stack

	private int N;				//define the stack size

	private class Node<Item>{	// helper linked list class
		private Item item;
		private Node<Item> next;
	}
	
	/**
	 * initializes an empty stack
	 */
	public StackSimuWithNode(){
		first = null;
		N = 0;
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return first == null;
	}
	
	/**
	 * push the item to stack
	 * @param item
	 */
	public void push(Item item){
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	/**
	 * delete and return the first node
	 * @return Item
	 */
	public Item pop(){
		if (isEmpty()) throw new NoSuchElementException("Stack underFlow"); 
		Item oldItem = first.item;
		first = first.next;
		N--;
		return oldItem;
	}
	
	
	/**
	 * return the last push item
	 * @return Item
	 */
	public Item peek(){
		if (isEmpty()) throw new NoSuchElementException("Stack underFlow"); 
		return first.item;
	}
	
	/**
	 * @return the item in stack from top to bottom
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (Item item : this){
			s.append(item + " ");
		}
		return s.toString();
	}
	
	/* 
	 * 实现Iterable的iterator方法
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Item> iterator(){
		return new StackIterator<Item>(first);
	}
	
	/**
	 * implement the iterator method
	 *
	 */

	@SuppressWarnings("hiding")
	private class StackIterator<Item> implements Iterator<Item>{
		//define currentNode
		private Node<Item> currentNode;
		private StackIterator(Node<Item> first){
			currentNode = first;
		}
		public boolean hasNext() {
			return currentNode != null;
		}

		public Item next() {
			Item currentItem = currentNode.item;
			currentNode = currentNode.next;
			return currentItem;
		}
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	@Test
	public void testStackSimuWithSingleNode(){
		String[] strlist = {"to","be","or","not","to","-","be","-","-","that","-","-","-","is"};
		StackSimuWithNode<String> stackSimuWithSingleNode = new StackSimuWithNode<String>();
		for(int i = 0; i < strlist.length; i++){
			if (strlist[i].equals("-")){
				System.out.println(stackSimuWithSingleNode.pop());
			}else{
				stackSimuWithSingleNode.push(strlist[i]);
			}
			System.out.println("SIZE:"+stackSimuWithSingleNode.size());
			System.out.println(toString());
		}
		
	}
	
}
