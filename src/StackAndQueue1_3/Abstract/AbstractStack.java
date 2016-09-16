package StackAndQueue1_3.Abstract;

public abstract class AbstractStack<Item> {
	public abstract <Node> void push(Node n, Item item);

	public abstract <Node> Item pop(Node n);

	public abstract <Node> Item peek(Node n);

	public abstract <Node> int size(Node n);

	public abstract <Node> boolean isEmpty(Node n);

}
