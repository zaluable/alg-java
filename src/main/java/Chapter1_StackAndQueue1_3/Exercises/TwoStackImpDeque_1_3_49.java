package Chapter1_StackAndQueue1_3.Exercises;

import java.util.NoSuchElementException;

import Chapter1_StackAndQueue1_3.StackSimuWithNode;
import Chapter1_StackAndQueue1_3.Interface.Deque;

public class TwoStackImpDeque_1_3_49<Item> implements Deque<Item> {
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
