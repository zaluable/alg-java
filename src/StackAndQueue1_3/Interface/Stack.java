package StackAndQueue1_3.Interface;

public interface Stack<Item> {

	public abstract boolean isEmpty();

	public abstract int size();

	public abstract void push(Item item);

	public abstract Item pop();

	public abstract Item peek();

}
