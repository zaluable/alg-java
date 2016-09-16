package StackAndQueue1_3.Exercises;

import java.util.NoSuchElementException;

import StackAndQueue1_3.Interface.Stack;

public class DequeImpTowStack_1_3_48<Item> implements Stack<Item> {
	private DuLNodeDeque_1_3_33<Item> deque;
	private int N1; // 标记大小
	private int N2;
	public DuLNodeDeque_1_3_33<Item>.Node stack1;
	public DuLNodeDeque_1_3_33<Item>.Node stack2;

	DequeImpTowStack_1_3_48() {
		this.deque = new DuLNodeDeque_1_3_33<Item>();
		N1 = 0;
		N2 = 0;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return N1;
	}

	public void push(Item item) {
		deque.pushLeft(item);
		N1++;
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Item temp = deque.popLeft();
			N1--;
			return temp;
		}
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return deque.getFirst().item;
		}
	}

	// stack2's methods
	public boolean stack2isEmpty() {
		return stack2Size() == 0;
	}

	public int stack2Size() {
		return N2;
	}

	public void stack2Push(Item item) {
		deque.pushRight(item);
		N2++;
	}

	public Item stack2Pop() {
		if (stack2isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Item temp = deque.popRight();
			N2--;
			return temp;
		}
	}

	public Item stack2Peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return deque.getLast().item;
		}
	}
}
