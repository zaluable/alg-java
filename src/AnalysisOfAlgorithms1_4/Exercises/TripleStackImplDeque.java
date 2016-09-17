package AnalysisOfAlgorithms1_4.Exercises;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import StackAndQueue1_3.StackSimuWithNode;
import StackAndQueue1_3.Interface.Deque;

public class TripleStackImplDeque<Item> implements Deque<Item> {

	private StackSimuWithNode<Item> stackL;

	private StackSimuWithNode<Item> stackR;

	TripleStackImplDeque() {
		stackL = new StackSimuWithNode<Item>();
		stackR = new StackSimuWithNode<Item>();
		System.out.println(stackL.hashCode());
		System.out.println(stackR.hashCode());
		System.out.println(stackR.equals(stackL));
	}

	protected Item switchPop(StackSimuWithNode<Item> stack) {
		StackSimuWithNode<Item> stackTemp = new StackSimuWithNode<Item>();
		while (!stack.isEmpty()) {
			stackTemp.push(stack.pop());
		}
		Item temp = stackTemp.pop();
		while (!stackTemp.isEmpty()) {
			stack.push(stackTemp.pop());
		}
		return temp;
	}

	public int size() {
		return stackL.size() + stackR.size();
	}

	public void pushLeft(Item item) {
		stackL.push(item);
	}

	public void pushRight(Item item) {
		stackR.push(item);

	}

	public Item popLeft() {
		if (!stackL.isEmpty()) {
			return stackL.pop();
		} else if (stackR.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return switchPop(stackR);
		}
	}

	public Item popRight() {
		if (!stackR.isEmpty()) {
			return stackR.pop();
		} else if (stackL.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return switchPop(stackL);
		}
	}
	
	@Test
	public void test(){
		TripleStackImplDeque<String> tr = new TripleStackImplDeque<String>();
	}
}
