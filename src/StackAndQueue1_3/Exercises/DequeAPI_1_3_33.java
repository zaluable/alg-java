/**
 *2016 上午10:47:41 
 *@author zhangxiao
 *
 * 说明：一个双向队列（或者成为deque）和栈或队列类似，但它同时支持在两段添加或删除元素
 * Deque能够存储一组元素并支持如下方法
 *          Deque（）                   创建空双向队列
 * boolean  isEmpty（）               双向队列是否为空
 * int      size()           双向队列中的元素数量
 * void     pushLeft（Item item）   向左端添加一个新元素
 * void     pushRight（Item item） 向右端添加一个新元素
 * Item     popLeft()             从左端删除一个元素
 * Item     popRight()            从右端删除一个元素
 * 
 * 编写一个使用双向链表实现这份API的Deque类，以及一个使用动态数组调整实现这份api的ResizingArrayDeque类
 */
package StackAndQueue1_3.Exercises;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeAPI_1_3_33<Item> implements Iterable<Item> {
	private int N;
	private Node first;
	private Node last;
	class Node{
		Item item;
		Node next;
		Node pre;
	}

	DequeAPI_1_3_33(){

	}
	public Node createNode(){
		return new Node();
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public void pushLeft(Item item){
		if(isEmpty()){
			first = createNode();
			first.item = item;
			last = first;
		}else{
			Node temp = createNode();
			temp.item = item;
			temp.next = first;
			first.pre = temp;
			first = temp;
		}
		N++;
	}
	public void pushRight(Item item){
		if(isEmpty()){
			last = createNode();
			last.item = item;
			first = last;
		}else{
			Node temp = createNode();
			temp.item = item;
			last.next = temp;
			temp.pre = last;
			last = temp;
		}
		N++;
	}
	public Item popLeft(){
		if (isEmpty()) throw new NoSuchElementException("the dequeue is Empty!");
		if (first.next == null){
			Item temp = first.item;
			first = null;
			last = null;
			N = 0;
			return temp;
		}else{
			Item temp = first.item;
			first.next.pre = null;
			first = first.next;
			N--;
			return temp;
		}
	}
	public Item popRight(){
		if (isEmpty())throw new NoSuchElementException("the dequeue is Empty!");
		if (last.pre == null){
			Item temp = last.item;
			first = null;
			last = null;
			N = 0;
			return temp;
		}else{
			Item temp = last.item;
			last.pre.next = null;
			last = last.pre;
			N--;
			return temp;
		}
	}
	public Iterator<Item> iterator(){
		return new IteratorDeque();
	}
	class IteratorDeque implements Iterator<Item>{
		Node point = first;
		@Override
		public boolean hasNext() {
			return point == null;
		}

		@Override
		public Item next() {
			Item temp = point.item;
			point = point.next;
			return temp;
		}

		@Override
		public void remove() {
			if (point.pre == null){
				point.next.pre = null;
				point = point.next;
			}
			
		}
		
	}	
//	public boolean caseAdd(){
//		
//	}
//	public boolean caseDe(){
//		
//	}
//	public Item[] resize(int arraySize){
//		
//	}
}
