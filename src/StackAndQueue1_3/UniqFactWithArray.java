package StackAndQueue1_3;

import java.util.Arrays;

import org.testng.annotations.Test;

public class UniqFactWithArray {
	// 不使用ArrayList的way1
	public int[] uniqFactWay1(int[] arr) {
		// 声明一个size变量指示uniq元素的size
		int size = 0;
		// 循环arr数组内元素
		for (int i = 0; i < arr.length; i++) {
			// 判断如果当前索引的元素是否与该元素之前的元素相等
			// 若相等，直接循环下一个元素
			if (isDul(arr, i)) {
				continue;
			}
			// 若不相等，将当前元素赋给size索引所在的位置，赋值后size自增1
			arr[size++] = arr[i];
		}
		// 循环完毕所有arr内元素后new一个新数组，将size索引前的数一一赋值给新数组
		return subArr(arr, size);
	}

	private Boolean isDul(int[] arr, int index) {
		for (int i = 0; i < index; i++) {
			if (arr[index] == arr[i])
				return true;
		}
		return false;
	}

	private int[] subArr(int[] arr, int size) {
		int[] newArr = new int[size];
		for (int i = 0; i < size; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}

	// test way1
	@Test
	public void testWay1() {
		// int[] arr = {2, 2, 1, 2, 6, 6, 8, 8, 8, 11, 12};
		int[] arr = { 2, 2, 1, 2 };
		System.out.println("Before Uniq:" + Arrays.toString(arr));
		int[] newArr = uniqFactWay1(arr);
		System.out.println("After Uniq:" + Arrays.toString(newArr));
	}

}
