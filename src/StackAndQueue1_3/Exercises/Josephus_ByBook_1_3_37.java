package StackAndQueue1_3.Exercises;

import java.util.ArrayDeque;
import java.util.Queue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Josephus_ByBook_1_3_37 {

	public void Josephus(int N, int M) {
		Queue<Integer> queue = new ArrayDeque<Integer>();

		for (int i = 0; i < N; i++) {
			queue.offer(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < M - 1; i++) {
				queue.offer(queue.remove());
			}
			System.out.println(queue.remove());
		}
	}

	@DataProvider(name = "Josephus")
	public Object[][] create() {
		return new Object[][] { { 7, 2 }, };
	}

	@Test(dataProvider = "Josephus", groups = "Exercises")
	public void testJosephus(int N, int M) {
		Josephus_ByBook_1_3_37 J = new Josephus_ByBook_1_3_37();
		J.Josephus(N, M);
	}
}
