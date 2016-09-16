package StackAndQueue1_3.Exercises;

import java.util.NoSuchElementException;

/**
 * 实现一个嵌套类DoubleNode用来构造双向链表，其中每个结点都含有一个指向前驱元素的引用 和一个指向后续元素的引用（如果不存在则为null）
 * 实现以下静态方法：在表头插入结点，在表尾插入结点， 从表头删除结点，从表尾删除结点 在指定结点前插入新结点，在指定结点后插入新结点 删除指定结点
 * 
 * @author xiao
 *
 */
public class LinkedWithDoubleNode_byMyWay_1_3_31<Item> {
	private DoubleNode head;
	private DoubleNode last;
	private int N;

	class DoubleNode {
		Item item;
		DoubleNode pre;
		DoubleNode next;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * 在表头插入结点
	 * 
	 * @param item
	 */
	public void addHead(Item item) {
		if (isEmpty()) {
			head = new DoubleNode();
			head.item = item;
			last = head;
		} else {
			DoubleNode temp = new DoubleNode();
			temp.item = item;
			temp.next = head;
			head.pre = temp;
			head = temp;
		}
		N++;
	}

	/**
	 * 在表尾插入结点
	 * 
	 * @param item
	 */
	public void addTail(Item item) {
		if (isEmpty()) {
			last = new DoubleNode();
			last.item = item;
			head = last;
		} else {
			DoubleNode temp = new DoubleNode();
			temp.item = item;
			last.next = temp;
			temp.pre = last;
			last = temp;
		}
		N++;
	}

	/**
	 * 从表头删除结点
	 * 
	 * @return
	 */
	public Item deHead() {
		if (isEmpty())
			return null;
		if (head.next == null) {
			Item temp = head.item;
			head = null;
			last = null;
			N--;
			return temp;
		} else {
			Item temp = head.item;
			head.next.pre = null;
			head = head.next;
			N--;
			return temp;
		}
	}

	/**
	 * 从表尾删除结点
	 * 
	 * @return
	 */
	public Item deTail() {
		if (isEmpty())
			return null;
		if (last.pre == null) {
			Item temp = last.item;
			head = null;
			last = null;
			N--;
			return temp;
		} else {
			Item temp = last.item;
			last.pre.next = null;
			last = last.pre;
			N--;
			return temp;
		}
	}

	/**
	 * 在指定结点前插入新结点
	 * 
	 * @param item
	 */
	public void insertPre(DoubleNode node, Item item) {
		DoubleNode preNode = node.pre;
		DoubleNode temp = new DoubleNode();
		temp.item = item;
		preNode.next = temp;
		temp.pre = preNode;
		temp.next = node;
		node.pre = temp;
		N++;
	}

	/**
	 * 在指定结点后插入新结点
	 * 
	 * @param item
	 */
	public void insertAft(DoubleNode node, Item item) {
		DoubleNode aftNode = node.next;
		DoubleNode temp = new DoubleNode();
		temp.item = item;
		node.next = temp;
		temp.pre = node;
		temp.next = aftNode;
		aftNode.pre = temp;
		N++;
	}

	/**
	 * 删除指定结点
	 * 
	 * @param item
	 */
	public Item delete(DoubleNode node) {
		if (isEmpty()) {
			throw new NoSuchElementException("DoubleLink underFlow");
		} else {
			Item temp = node.item;
			DoubleNode preNode = node.pre;
			DoubleNode aftNode = node.next;
			preNode.next = aftNode;
			aftNode.pre = preNode;
			N--;
			return temp;
		}
	}
}
