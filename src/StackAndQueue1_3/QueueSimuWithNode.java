package StackAndQueue1_3;

import java.util.Iterator;

import org.testng.annotations.Test;

import StackAndQueue1_3.Interface.Collection;

public class QueueSimuWithNode<Item> implements Collection<Item> {
	private Node first; // the head of Q
	private Node last; // the tail of Q
	private int N; // the Q's size

	protected class Node { // helper link the item
		Item item;
		Node next;

		Node() {

		}

		Node(Item item) {
			this.item = item;
		}
	}

	public static <T extends QueueSimuWithNode<Item>, Item> T catenation(T q1, T q2) {
		while (!q2.isEmpty()) {
			q1.enqueue(q2.dequeue());
		}
		return q1;
	}

	public Node create(Item item) {
		return new Node(item);
	}

	protected QueueSimuWithNode() {

	}

	protected QueueSimuWithNode(Item item) {
		first = create(item);
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() { // assert empty
		return N == 0;
	}

	/**
	 * add the item to the tail of Q
	 * 
	 * @param to
	 *            be add item
	 */
	public void enqueue(Item item) {
		Node oldLast = last; // 声明一个oldLast变量引用队列末尾node
		last = new Node();
		last.item = item; // 将被添加的item赋给新node.item
		last.next = null;
		if (isEmpty()) { // 如果Q为空， last node 的引用赋值给first node
			first = last; // 在添加元素的时候需要考虑队首元素的值，否则如果只添加而不对first添加引用，删除的时候就会报错
		} else {
			oldLast.next = last;// 反之，last node 的引用赋值给oldLast node
		}
		N++;
	}

	/**
	 * @return the deleted item
	 */
	public Item dequeue() {
		Item oldItem = first.item;// 删除队首元素前将其item的引用赋给 oldItem
		first = first.next; // 将first变量直接引用（指向）first.next，达到删除队首元素的目的
		if (isEmpty()) { // 如果Q为空，（可能last之前不为null，可是连续删除的情况下，要判断是不是last已经被删掉了）
			last = null;
		}
		N--;
		return oldItem;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this) {
			s.append(item + " ");
		}
		return s.toString();
	}

	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
		private Node currcent = first;

		public boolean hasNext() {
			return currcent != null;
		}

		public Item next() {
			Item itemTemp = currcent.item;
			currcent = currcent.next;
			return itemTemp;
		}

		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	@Test
	public void testQueueSimuWithNode() {
		String[] testStr = { "to", "be", "-", "not" };
		QueueSimuWithNode<String> queueSimuWithNode = new QueueSimuWithNode<String>();
		for (int i = 0; i < testStr.length; i++) {
			if (testStr[i].equals("-")) {
				queueSimuWithNode.dequeue();
			} else {
				queueSimuWithNode.enqueue(testStr[i]);
			}
			System.out.print("elements are:" + toString());
		}
	}

}
