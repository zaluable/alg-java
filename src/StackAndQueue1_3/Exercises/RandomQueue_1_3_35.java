/**
 * 2016 上午11:34:09 
 * 编写一个randomqueue类来实现这份API
 *         RandomQueue（）          创建一条空的随机队列
 * boolean isEmpty()          队列是否为空
 * void    enqueue(Item item) 添加一个元素
 * Item    dequeue()          删除并随机返回一个元素（取样且不放回）
 * Item    sample（）                       随机返回一个元素但不删除他（取样且放回） 
 * 
 */
package StackAndQueue1_3.Exercises;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue_1_3_35<Item> implements Iterable<Item>{
	private Item[] arr;
	private int N;
	private int arrLength;
	@SuppressWarnings("unchecked")
	RandomQueue_1_3_35(int arrLength){
		arr = (Item[])new Object[arrLength];
		this.arrLength = arrLength;
	}	
	public boolean isEmpty(){
		return N == 0;
	}
	public boolean isFull(){
		return N == arrLength;
	}
	public Item[] resize(int newsize){
		@SuppressWarnings("unchecked")
		Item[] newArr = (Item[])new Object[newsize];
		for (int i = 0; i < arr.length;i++){
			newArr[i] = arr[i];
		}
		arrLength = newsize;
		arr = newArr;
		return arr;
	}
	
	public void enqueue(Item item){
		arr[N++] = item;
		if(isFull()){
			resize(2*arrLength);
		}
	}
	
	public Item dequeue(){
		if (isEmpty()) throw new NoSuchElementException();		
		if (N > 1) exchange();		
		Item temp = arr[--N];
		if (arrLength/(arrLength - N) == 4){
			resize(1/2*arrLength);
		}
		return temp;
	}
	
	public Item sample(){
		int sampleIndex = randomIndex(N+1);
		return arr[sampleIndex];
	}
	
	public void exchange(){
		int exIndex = randomIndex(N);
		Item temp = arr[exIndex];
		arr[exIndex] = arr[N-1];
		arr[N-1] = temp;
	}
	
	public int randomIndex(int index){
		int i = (int)(Math.random()*index);
		return i;
	}
	
	public Iterator<Item> iterator(){
		return new RandomQueueIter();
	}
	
	class RandomQueueIter implements Iterator<Item>{
		private int tempIndex = 0;
		@Override
		public boolean hasNext() {
			if (isEmpty()) return false;
			if (tempIndex < N){
				tempIndex++;
				return true;
			}else{
				return false;
			}
		}

		@Override
		public Item next() {
			return arr[tempIndex];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	} 
}
