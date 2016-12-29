package Chapter1_StackAndQueue1_3;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

/**
 * 1.用定长数组的形式实现Q的数据接口，并且可以自动调整长度 2.实现isEmpty，size，dequeue，enqueue，Iterator的方法
 * 
 * @author xiao
 *
 */
public class QueueSimuWithArray<T> {
	private int headIndex;
	private int tailIndex;
	private T[] baseQ;
	private int initCap;

	private QueueSimuWithArray(int initCap) {
		baseQ = (T[]) new Object[initCap];
		headIndex = 0;
		tailIndex = 0;
		headIndex = 0;
		this.initCap = initCap;
	}

	private QueueSimuWithArray() {

	}

	public int size() {
		return tailIndex - headIndex;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void enqueue(T t) {
		if (initCap == tailIndex) {
			resize(initCap * 2);
		}
		if (isEmpty()) {
			baseQ[headIndex] = t;
		} else {
			baseQ[tailIndex] = t;
		}
		tailIndex++;
	}

	public T dequeue() {
		if (size() == initCap / 4) {
			resize(initCap / 2);
		}
		if (isEmpty()) {
			throw new NoSuchElementException("the Q is Empty,nothing to delete");
		}
		T temp = baseQ[headIndex];
		baseQ[headIndex] = null;
		headIndex++;
		return temp;
	}

	public T[] resize(int target) {
		System.out.println("resize to:" + target);
		T[] temp = (T[]) new Object[target];
		for (int i = 0; i < this.size(); i++) {
			temp[i] = baseQ[headIndex + i];
		}
		int sizeTemp = this.size();
		headIndex = 0;
		tailIndex = sizeTemp + headIndex;
		baseQ = temp;
		return baseQ;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = headIndex; i < tailIndex; i++) {
			if (baseQ[i] != null) {
				s.append(baseQ[i].toString() + " ");
			} else {
				continue;
			}
		}
		return s.toString();
	}

	@Test
	public void testQueueSimuWithArray() {
		QueueSimuWithArray<String> q = new QueueSimuWithArray<String>(5);
		// String[] strlist =
		// {"to","be","or","not","to","-","be","-","-","that","-","-","-","is"};
		String[] strlist = { "to", "be", "or", "not", "to", "1", "-", "-", "-", "-", "-", "-", "2" };
		for (String str : strlist) {
			if (str.equals("-")) {
				q.dequeue();
			} else {
				q.enqueue(str);
			}
			System.out.println("Size:" + q.size());
			System.out.println(q.toString());
		}

	}
}
