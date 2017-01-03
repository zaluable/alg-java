package Chapter2_ElementarySorts2_2;

import org.testng.annotations.Test;

/**
 * Created by zhangxiao3 on 2017/1/3.
 */
public class Merge {
    public static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    //自顶向下
    //recursion separate array , merge array
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    //原地归并
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        Comparable[] aux = new Comparable[hi+1];
        //归并lo——mid, mid+1——hi
        int i = lo;
        int j = mid+1;
        //copy array
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        //merge array
        for (int k = lo; k <= hi; k++) {
            if(i > mid)                     a[k] = aux[j++];
            else if(j > hi)                 a[k] = aux[i++];
            else if(less(aux[j], aux[i]))   a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
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
    public void testMerge(){
//        Comparable[] a = {"B", "C", "A"};
        Comparable[] a = {2, 1, 3, 0, 4};
        show(a);
        sort(a);
        show(a);
        System.out.print(isSorted(a));
    }
}
