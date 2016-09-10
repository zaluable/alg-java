package StackAndQueue1_3;

import java.util.Arrays;

import org.testng.annotations.Test;

public class BinarySearchIntWithArray {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key > a[mid]) {
				lo = mid + 1;
			} else if (key < a[mid]) {
				hi = mid - 1;
			} else {
				return a[mid];
			}
		}

		return -1;
	}

	@Test
	// unit test
	public void testRank() {
		int[] a = { 2, 3, 4, 5, 6 };
		int key = 5;
		Arrays.sort(a);
		System.out.println(rank(key, a));
	}
}
