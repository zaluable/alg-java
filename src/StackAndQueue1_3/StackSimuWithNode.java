package StackAndQueue1_3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import StackAndQueue1_3.Interface.Collection;
import StackAndQueue1_3.Interface.Stack;

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
public class StackSimuWithNode<Item> implements Collection<Item>, Stack<Item> {

	private Node first; // define the top node of the stack

	private int N; // define the stack size

	private int pushCount = 0;

	private int popCount = 0;

	public class Node { // helper linked list class
		Item item;
		Node next;
	}

	/**
	 * initializes an empty stack
	 */
	public StackSimuWithNode() {
		first = null;
		N = 0;
	}

	public static <T extends StackSimuWithNode<Item>, Item> T catenation(T s1, T s2) {
		StackSimuWithNode<Item> temp = new StackSimuWithNode<Item>();
		temp.equals(temp);
		while (!s1.isEmpty()) {
			temp.push(s1.pop());
		}
		while (!temp.isEmpty()) {
			s2.push(temp.pop());
		}
		return s2;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * push the item to stack
	 * 
	 * @param item
	 */
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
		pushCount++;
	}

	/**
	 * delete and return the first node
	 * 
	 * @return Item
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underFlow");
		Item oldItem = first.item;
		first = first.next;
		N--;
		popCount++;
		return oldItem;
	}

	/**
	 * return the last push item
	 * 
	 * @return Item
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underFlow");
		return first.item;
	}

	/**
	 * @return the item in stack from top to bottom
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this) {
			s.append(item + " ");
		}
		return s.toString();
	}

	/**
	 * 实现Iterable的iterator方法 (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Item> iterator() {
		return new StackIterator(first, pushCount, popCount);
	}

	/**
	 * implement the iterator method
	 *
	 */
	public class StackIterator implements Iterator<Item> {
		// define currentNode
		private Node currentNode;
		private int inCount;
		private int outCount;

		private boolean check() {
			return (inCount == pushCount && outCount == popCount);
		}

		private StackIterator(Node first, int pushCount, int popCount) {
			currentNode = first;
			inCount = pushCount;
			outCount = popCount;
		}

		public boolean hasNext() {
			if (!check()) {
				throw new ConcurrentModificationException();
			} else {
				return currentNode != null;
			}
		}

		public Item next() {
			if (!check()) {
				throw new ConcurrentModificationException();
			} else {
				Item currentItem = currentNode.item;
				currentNode = currentNode.next;
				return currentItem;
			}
		}

		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	@Test
	public void testStackSimuWithSingleNode() {
		String[] strlist = { "to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is" };
		StackSimuWithNode<String> stackSimuWithSingleNode = new StackSimuWithNode<String>();
		for (int i = 0; i < strlist.length; i++) {
			if (strlist[i].equals("-")) {
				System.out.println(stackSimuWithSingleNode.pop());
			} else {
				stackSimuWithSingleNode.push(strlist[i]);
			}
			System.out.println("SIZE:" + stackSimuWithSingleNode.size());
			System.out.println(toString());
		}

	}

}
