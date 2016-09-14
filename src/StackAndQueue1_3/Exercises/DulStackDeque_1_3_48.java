package StackAndQueue1_3.Exercises;

import java.util.NoSuchElementException;

import StackAndQueue1_3.StackSimuWithNode;
import StackAndQueue1_3.Interface.DequeInterface;

public class DulStackDeque_1_3_48<Item> implements DequeInterface<Item> {
	private StackSimuWithNode<Item> stackLeft;
	private StackSimuWithNode<Item> stackRight;

	public int size() {
		return stackLeft.size() + stackRight.size();
	}

	public void pushLeft(Item item) {
		if (stackLeft.isEmpty())
			stackRight.push(item);
		else {
			pullElements(stackLeft, stackRight);
			stackRight.push(item);
		}
	}

	public void pushRight(Item item) {
		if (stackRight.isEmpty())
			stackLeft.push(item);
		else {
			pullElements(stackRight, stackLeft);
			stackLeft.push(item);
		}

	}

	public Item popLeft() {
		if (size() == 0) {
			throw new NoSuchElementException();
		} else {
			pullElements(stackLeft, stackRight);
		}
		return stackRight.pop();
	}

	public Item popRight() {
		if (size() == 0) {
			throw new NoSuchElementException();
		} else {
			pullElements(stackRight, stackLeft);
		}
		return stackLeft.pop();
	}

	public void pullElements(StackSimuWithNode<Item> water, StackSimuWithNode<Item> bucket) {
		while (!water.isEmpty()) {
			bucket.push(water.pop());
		}
	}

}
