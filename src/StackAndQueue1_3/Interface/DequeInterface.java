package StackAndQueue1_3.Interface;

public interface DequeInterface<Item> {
	
	public abstract int size();		//双向队列中元素的数量
	
	public abstract void pushLeft(Item item);		//向左端添加一个元素
	
	public abstract void pushRight(Item item);		//向右端添加一个元素
	
	public abstract Item popLeft();					//从左端删除一个元素
	
	public abstract Item popRight();				//从右端删除一个元素
}
