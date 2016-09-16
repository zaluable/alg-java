package StackAndQueue1_3.Exercises;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 用栈实现一个匹配大中小括号的程序 1.匹配大中小括号出现的优先级（’{[((‘） 2.匹配括号是否配对，即栈顶元素是否与被迭代字符配对
 * 
 * @author xiao
 *
 * @param <Item>
 */
public class ParenthesesCheck_byMyWay_1_3_4<Item> implements Iterable<Item> {
	private int size = 0;
	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;

		// System.out.println("push:"+item);
		// System.out.println("Size:"+size);
		// System.out.println("First:"+first.item);
	}

	public Item pop() {
		Item itemTemp = first.item;
		first = first.next;
		size--;
		// System.out.println("pop:"+itemTemp);
		// System.out.println("Size:"+size);
		// System.out.println("First:"+first.item);
		return itemTemp;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private class ParenthesesCheckIterator implements Iterator<Item> {
		private Node currentNode = first;

		public boolean hasNext() {
			return currentNode != null;
		}

		public Item next() {
			Item currentItem = currentNode.item;
			currentNode = currentNode.next;
			return currentItem;
		}

		public void remove() {
			// TO DO
		}
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ParenthesesCheckIterator();
	}

	// 迭代循环元素，如果能匹配就将元素出栈，如果不能匹配就将元素入栈
	public void iterCheck(Item patten) {
		if (checkPair(patten)) {
			pop();
		} else {
			push(patten);
		}
	}

	// 校验是否被迭代元素与栈顶元素配对
	public boolean checkPair(Item patten) {
		if (patten.equals("}") && first.item.equals("{")) {
			return true;
		} else if (patten.equals("]") && first.item.equals("[")) {
			return true;
		} else if (patten.equals(")") && first.item.equals("(")) {
			return true;
		} else {
			return false;
		}
	}

	// 校验括号的次序
	// 1.被比较对象如果是{，那么迭代栈内元素，若有元素是{,[,(其中之一，return false
	// 2.被比较对象如果是[，那么迭代栈内元素，若有元素是[,(，其中之一，return false
	public boolean checkOrder(Item patten) {
		if (patten.equals("{")) {
			Iterator<Item> itermIterator = this.iterator();
			while (itermIterator.hasNext()) {
				Item beIterator = itermIterator.next();
				if (beIterator.equals("{") || beIterator.equals("[") || beIterator.equals("("))
					return false;
			}
			return true;
		} else if (patten.equals("[")) {
			Iterator<Item> itermIterator2 = this.iterator();
			while (itermIterator2.hasNext()) {
				Item beIterator = itermIterator2.next();
				if (beIterator.equals("[") || beIterator.equals("("))
					return false;
			}
			return true;
		} else
			return true;
	}

	public boolean checkParentheses(Item[] items) {
		for (Item item : items) {
			if (checkOrder(item)) {
				iterCheck(item);
			} else
				return false;
		}
		if (isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@DataProvider(name = "Strdata")
	public Object[][] dataProvide(Method method) {
		String[] strCase1 = { "{", "}", "[", "(", "(", ")", ")", "]" };
		String[] strCase2 = { "{", "[", "(", ")", ")", "]", "}" };
		String[] strCase3 = { "{", "(", "[", "]", ")", "}" };
		String[] strCase4 = { "(", "[", "{", "}", "]", ")" };
		return new Object[][] { { strCase1, true }, { strCase2, false }, { strCase3, false }, { strCase4, false }, };
	}

	@Test(dataProvider = "Strdata", groups = "Exercises")
	public void testParenthesesCheck(String[] strlist, boolean expected) {
		// {}[(())]
		// String[] strCase1 = {"{","}","[","(","(",")",")","]"};
		// {[())]}
		// String[] strCase2 = {"{","[","(",")",")","]","}"};
		// {([])}
		// String[] strCase3 = {"{","(","[","]",")","}"};
		// ([{}])
		// String[] strCase4 = {"(","[","{","}","]",")"};
		ParenthesesCheck_byMyWay_1_3_4<String> parenthesesCheck = new ParenthesesCheck_byMyWay_1_3_4<String>();
		Assert.assertEquals(parenthesesCheck.checkParentheses(strlist), expected);

	}
}
