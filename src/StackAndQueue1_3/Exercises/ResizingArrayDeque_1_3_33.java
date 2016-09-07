package StackAndQueue1_3.Exercises;

/**
 * @author xiao
 *
 */
public class ResizingArrayDeque_1_3_33<Item> {
	private int N;
	private Node first;
	private Node last;
	private int arrSize;
	private Item[] itemBox;
	class Node{
		Item item;
		Node pre;
		Node next;
	}
	@SuppressWarnings("unchecked")
	ResizingArrayDeque_1_3_33(int arrSize){
		itemBox = (Item[])new Object[arrSize];
		this.arrSize = arrSize;
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public void pushLeft(Item item){
		
	}
	public void pushRight(Item item){
		
	}
	public Item popLeft(){
		
	}
	public Item popRight(){
		
	}
	public boolean caseAdd(){
	
	}
	public boolean caseDe(){
	
	}
	public Item[] resize(int arraySize){
	
	}
//	public class QueueTest {
//		private int maxSize;
//		private int size;
//		private long[] queArray;
//		private int front;
//		private int rear;
//
//		public QueueTest(int s){
//			this.maxSize = s+1;
//			this.queArray = new long[maxSize];
//			this.front = 0;
//			this.rear = -1;
//			this.size = 0;
//		}
//		
//		//从对头开始增加
//		public void addFront(long j){
//			if(front == 0){
//				front = maxSize;
//			}
//			queArray[--front] = j;
//			size++;
//		}
//		
//		//从尾部开始增加
//		public void addRear(long j){
//			if(rear == maxSize - 1){
//				rear = -1;
//			}
//			queArray[++rear] = j;
//			size++;
//		}
//		
//		//删除头部第一个
//		public long removeFront(){
//			long temp = queArray[front++];
//			if(front == maxSize){
//				front = 0;
//			}
//			size--;
//			return temp;
//		}
//		
//		//删除尾部最后一个
//		public long removeRear(){
//			long temp = queArray[rear--];
//			if((rear == -1)){
//				rear = maxSize - 1;
//			}
//			size--;
//			return temp;
//		}
//		
//		public boolean inEmpty(){
//			return size == 0;
//		}
//		
//		public boolean ifFull(){
//			return size == maxSize;
//		}
//		public long peet(){
//			return queArray[front];
//		}
//		
//		public int size(){
//			return this.size;
//		}
//		
}
