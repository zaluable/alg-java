package StackAndQueue1_3.Exercises;

import java.util.NoSuchElementException;

/**
 * 一个以栈为目标的队列，是一种支持push，pop，enqueue的操作的数据类型
 * 为这种抽象数据类型定义一份API并给出一份基于链表的实现
 * @author zhangxiao3
 *
 */
public class StequeAPI_1_3_32<Item> implements Catenation_1_3_47<Item>{
	private int N;
	private Node first;
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
	@Override
	public Item catenat(Item t1, Item t2) {
		// TODO Auto-generated method stub
		return null;
	}
}
