package Chapter2_ElementarySorts2_3;

import org.testng.annotations.Test;

import java.util.Comparator;

/**
 * Created by zhangxiao on 2017/1/3.
 */
public class Quick {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int j = patition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int patition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        Comparable v = a[i];
        while(true){
            while (less(a[++i], v)){
                if(i == hi){
                    break;
                }
            }
            while(less(v, a[--j])){
                if(j == lo){
                    break;
                }
            }
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
        for (Comparable anA : a) {
            System.out.print(anA + " ");
        }
        System.out.println("  ");
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testQuick(){
//        Comparable[] a = {"B", "C", "A"};
        Comparable[] a = {2, 1, 3, 0, 4};
        show(a);
        sort(a);
        show(a);
        System.out.print(isSorted(a));
    }
}
