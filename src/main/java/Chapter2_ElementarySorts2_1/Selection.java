package Chapter2_ElementarySorts2_1;

import org.testng.annotations.Test;

/**
 * Created by zhangxiao3 on 2016/12/29.
 */
public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for(int j = i+1; j < N; j++){
                if(less(a[j], a[min])){
                    min = j;
                    exch(a, i, min);
                }
            }
        }
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i-1], a[i])){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testCase(){
        Comparable[] a = {2, 1, 3, 0, 4};
        show(a);
        sort(a);
        show(a);
        System.out.print(isSorted(a));
    }
}
