package Chapter1_StackAndQueue1_3.Exercises;

import java.util.Arrays;

import org.testng.annotations.Test;

/**
 * 环形缓冲区。 又称为环形队列，是一种定长为N的先进先出的数据结构，他在进程间的异步数据传输或记录日志文件时十分有效。
 * 当缓冲区为空时，消费者会在数据存入缓冲区前等待， 当缓冲区满了时，生产者会等待将数据存入缓冲区 为其设计一份API 用回环数组将其实现
 * 
 * RingBuffer() boolean isEmpty() boolean isFull() void enqueue(Message msg)
 * Message dequeue()
 */
public class RingBuffer_1_3_39<Message> {
	private Message[] msgArr;
	private int arrLength;
	private int head;
	private int tail;
	private int msgLength;

	@SuppressWarnings("unchecked")
	RingBuffer_1_3_39(int N) {
		msgArr = (Message[]) new Object[N];
		arrLength = N;
		head = 0;
		tail = 0;
		msgLength = 0;
	}

	RingBuffer_1_3_39() {
	}

	public boolean isEmpty() {
		return msgLength == 0;
	}

	public boolean isFull() {
		return msgLength == arrLength;
	}

	public void enqueue(Message msg) {
		if (isEmpty()) {
			msgArr[head] = msg;
			msgLength++;
		} else if (!isEmpty() && !isFull()) {
			tail = (tail + 1) % arrLength;
			msgArr[tail] = msg;
			msgLength++;
			System.out.println(toString());
		} else {
			System.out.println("enqueue:" + msg + "is fail");
		}
	}

	public Message dequeue() {
		if (isEmpty())
			return null;
		Message msgTemp = msgArr[head];
		head = (head + 1) % arrLength;
		msgLength--;
		System.out.println("After dequeue " + msgTemp + ":" + toString());
		return msgTemp;
	}

	public String toString() {
		if (isEmpty())
			return "[]";
		if (head < tail) {
			@SuppressWarnings("unchecked")
			Message[] temp = (Message[]) new Object[msgLength];
			System.arraycopy(msgArr, head, temp, 0, (tail - head + 1));
			return Arrays.toString(temp);
		} else {
			@SuppressWarnings("unchecked")
			Message[] temp = (Message[]) new Object[msgLength];
			System.arraycopy(msgArr, head, temp, 0, arrLength - head);
			System.arraycopy(msgArr, 0, temp, arrLength - head, tail + 1);
			return Arrays.toString(temp);
		}
	}

	@Test
	public void testRingBuffer() {
		RingBuffer_1_3_39<String> ringBuffer = new RingBuffer_1_3_39<String>(5);
		// String[] str = {"a"};
		ringBuffer.enqueue("a");
		ringBuffer.enqueue("b");
		ringBuffer.enqueue("c");
		ringBuffer.enqueue("d");
		ringBuffer.enqueue("e");
		ringBuffer.enqueue("f");
		ringBuffer.dequeue();
		ringBuffer.enqueue("f");
	}
}
