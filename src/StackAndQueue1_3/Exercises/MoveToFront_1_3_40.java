/**
 *  2016 8:00:03 AM
 *  xiao
 *  前移编码，读入一串字符，使用链表保存这些字符并清除重复字符，当你读取了一个新的字符，将其插入链表头
 *  当你读取了一个从未见过的字符，将它从链表中删去并重新插入链表头
 *  它实现了著名的前移编码策略 这种策略假设最近访问过的元素可能会再次访问，因此可以用于缓存，数据压缩等场景。
 *  我将使用单向链表来实现，每次插入数据时需要遍历链表
 */
package StackAndQueue1_3.Exercises;

import org.testng.annotations.Test;

public class MoveToFront_1_3_40<Item> {
	private Node first; // 链表头

	class Node {
		Item item;
		Node next;

		Node(Item item) {
			this.item = item;
		}
	}

	public void push(Item item) {
		if (first == null) {
			first = new Node(item);
		} else {
			if (first.item == item)
				return;
			find(item);
			Node temp = new Node(item);
			temp.next = first;
			first = temp;
		}
	}

	public void find(Item item) {
		Node tempOne;
		Node tempTwo;
		tempOne = first;
		while (tempOne.next != null) {
			tempTwo = tempOne.next;
			if (tempTwo.item == item) {
				tempOne.next = tempTwo.next;
				break;
			} else {
				tempOne = tempTwo;
			}
		}
	}

	public String toString() {
		Node temp = first;
		StringBuilder stringBuilder = new StringBuilder();
		if (temp != null) {
			stringBuilder.append(temp.item);
			while (temp.next != null) {
				temp = temp.next;
				stringBuilder.append(temp.item);
			}
		}
		return stringBuilder.toString();
	}

	@Test
	public void testMoveToFront() {
		MoveToFront_1_3_40<Character> moveToFront = new MoveToFront_1_3_40<Character>();
		String s = "abcadc";
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			moveToFront.push(temp);
			System.out.println("push:" + temp + "==" + moveToFront.toString());
		}
		System.out.println(moveToFront.toString());
	}

}
