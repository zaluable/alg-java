package StackAndQueue1_3.Exercises;

import java.util.Iterator;
import java.util.NoSuchElementException;

import StackAndQueue1_3.Interface.CollectionInterface;

/**
 * 一个以栈为目标的队列，是一种支持push，pop，enqueue的操作的数据类型
 * 为这种抽象数据类型定义一份API并给出一份基于链表的实现
 * 
 *
 */
public class StequeAPI_1_3_32<Item> implements CollectionInterface<Item>{
	private int N;
	private Node first;
	private Node last;
	class Node{
		Item item;
		Node next;
	}
	
	public static <Item> StequeAPI_1_3_32<Item> catenation(StequeAPI_1_3_32<Item> steque1, StequeAPI_1_3_32<Item> steque2){
		while (!steque2.isEmpty()){
			steque1.enqueue(steque2.pop());
		}
		return steque1;
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public Node createNode(){
		return new Node();
	}
	public void push(Item item){
		if(isEmpty()){
			first = createNode();
			first.item = item;
			last = first;
		}else{
			Node temp = createNode();
			temp.item = item;
			temp.next = first;
			first = temp;
		}
		N++;
	}
	public void enqueue(Item item){
		if(isEmpty()){
			last = createNode();
			last.item = item;
			first = last;
		}else{
			Node temp = createNode();
			temp.item = item;
			last.next = temp;
			last = temp;
		}
		N++;
	}
	public Item pop(){
		if(isEmpty()){
			throw new NoSuchElementException("the steque is empty,nothing to delete");
		}else{
			Item temp = first.item;
			first = first.next;
			N--;
			return temp;
		}
	}
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
