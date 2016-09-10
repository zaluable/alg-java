package StackAndQueue1_3.Exercises;

import org.testng.annotations.Test;

public class GeneralizedQueueWithNode_1_3_38<Item> {
	private Node first;
	private Node last;
	private int N;

	class Node {
		Item item;
		Node next;

		Node(Item item) {
			this.item = item;
		}
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(Item item) {
		if (isEmpty()) {
			first = new Node(item);
			last = first;
			N++;
		} else {
			last.next = new Node(item);
			last = last.next;
			N++;
		}
	}

	public Item delete(int k) {
		if (isEmpty())
			return null;
		int count = 0;
		Node temp = first;
		while (count != k - 1) {
			count++;
			temp = temp.next;
		}
		Item itemTemp = temp.next.item;
		temp = temp.next.next;
		N--;
		return itemTemp;
	}

	@Test
	public void testGeneralizedQueueWithNode() {
		GeneralizedQueueWithNode_1_3_38<String> g = new GeneralizedQueueWithNode_1_3_38<String>();
		String[] test = { "a", "b", "c", "d", "e" };
		for (String str : test) {
			g.insert(str);
		}
		System.out.println(g.delete(2));
	}
}
