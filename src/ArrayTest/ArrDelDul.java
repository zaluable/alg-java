package ArrayTest;

import java.util.Arrays;

import org.testng.annotations.Test;



public class ArrDelDul {
	@Test
    public  void testArrDelDul() {
        int[] arr = {2, 2, 1, 2};
        System.out.println(Arrays.toString(arr));
        int[] arr2 = diff(arr);

        System.out.println(Arrays.toString(arr2));
    }
 
    private static int[] diff(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hasSame(arr, i)) {
                continue;
            }
            arr[index++] = arr[i];
        }
        return subArray(arr, index);
    }
 
    private static int[] subArray(int[] arr, int size) {
        int[] arr2 = new int[size];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }
 
    private static boolean hasSame(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[index] == arr[i]) {
                return true;
            }
        }
        return false;
    }
}