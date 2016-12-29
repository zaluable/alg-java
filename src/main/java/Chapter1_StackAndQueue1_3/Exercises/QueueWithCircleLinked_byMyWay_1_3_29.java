package Chapter1_StackAndQueue1_3.Exercises;

public class QueueWithCircleLinked_byMyWay_1_3_29<Item> {
	private int N;
	private Node last;

	class Node {
		Item item;
		Node next;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void enqueue(Item item) {
		if (isEmpty()) {
			last = new Node();
			last.item = item;
			last = last.next;
		} else {
			Node temp = new Node();
			temp.item = item;
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		N++;
	}

	public Item dequeue() {
		Item temp = last.next.item;
		last = last.next.next;
		N--;
		return temp;
	}
}
