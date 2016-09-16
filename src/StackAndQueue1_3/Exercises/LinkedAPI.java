/**
 * 编写一个stack的用例
 * 1.接受一个命令行参数k并打印出倒数第k个数字（假设入参中至少有k个字符串)
 * 2.接受一个命令行参数k并打删除第k个数字
 * 
 */
package StackAndQueue1_3.Exercises;

/**
 * @author zhangxiao3
 *
 */
public class LinkedAPI<Item extends Comparable<Item>> {
	private Node first;
	private int N;

	private class Node {
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	/**
	 * 返回第k个元素
	 * 
	 * @param head
	 * @param k
	 * @return 第k个元素
	 */
	public Node getElement(int k) {
		if (first == null || k <= 0)
			return null;
		Node pre = first;
		Node last = first;
		for (int i = 1; i < k; i++) {
			if (pre.next != null) {
				pre = pre.next;
			} else {
				return null;
			}
		}
		while (pre.next != null) {
			pre = pre.next;
			last = last.next;
		}
		return last;
	}

	/**
	 * 删除第K个元素
	 * 
	 * @param head
	 * @param k
	 * @return deleted element
	 */
	public Node delElement(int k) {
		if (first == null || k <= 0)
			return null;
		Node pre = first;
		for (int i = 1; i < (k - 1); i++) {
			if (pre.next != null) {
				pre = pre.next;
			} else {
				return null;
			}
		}
		if (pre.next != null) {
			pre = pre.next.next;
			return pre;
		} else {
			return null;
		}

	}

	// public Item delete(Node node){
	//
	// }

	/**
	 * 1_3_26 编写一个方法remove，接受一条链表和一个字符串key作为参数，删除聊表中所有的item域为key的结点
	 * 
	 * @param item
	 */
	public void remove(String key) {
		while (key.equals(first.item)) {
			first = first.next;
			N--;
		}
		Node temp = first;
		while (temp != null) {
			if (temp.next != null && key.equals(temp.next.item)) {
				temp.next = temp.next.next;
				N--;
			} else {
				temp = temp.next;
			}
		}
	}

	/**
	 * 传首结点进来，返回链表中的max item
	 * 
	 * @param first
	 * @return
	 */
	public Item max(Node first) {
		if (first == null)
			return null;
		else {
			Item max = first.item;
			Node temp = first.next;
			while (temp != null) {
				if (max.compareTo(temp.item) < 0) {
					max = temp.item;
				}
				temp = temp.next;
			}
			return max;
		}
	}

	/**
	 * reverse链表用循环的方式
	 * 
	 * @param head
	 * @return
	 */
	public Node reverseWithCycle(Node head) {
		Node reverse = null;
		Node first = head;
		while (first != null) {
			Node second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}

	/**
	 * reverse链表用递归的方式
	 * 
	 * @param node
	 *            传入首结点
	 * @return
	 */
	public Node reverseWithRicursion(Node node) {
		if (node == null || node.next == null)
			return node;
		Node nextNode = node.next;
		node.next = null;
		Node rest = reverseWithRicursion(nextNode);
		nextNode.next = node;
		return rest;
	}
}
