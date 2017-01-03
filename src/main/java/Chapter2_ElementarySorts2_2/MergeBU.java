package Chapter2_ElementarySorts2_2;

import org.testng.annotations.Test;

import java.awt.event.ComponentAdapter;

/**
 * Created by zhangxiao3 on 2017/1/3.
 */
public class MergeBU {
    private static Comparable[] aux;
    //自底向上
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[a.length];
        for (int sz = 1; sz < N; sz=sz+sz) {
            for (int lo = 0; lo < N-sz ; lo+= sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        //copy array
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        int m = lo;
        int n = mid+1;
        /*
        左边取完，取右边
        右边取完，取左边
        当前m元素<n元素，取m
        否则，取n
        */
        for (int i = lo; i < a.length; i++) {
            if(m > mid)                     a[i] = aux[n++];
            else if(n > hi)                 a[i] = aux[m++];
            else if(less(aux[m], aux[n]))   a[i] = aux[m++];
            else                            a[i] = aux[n++];
        }
    }
    public boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length-1; i++) {
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");
    }
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    @Test
    public void testMergeBU(){
        //        Comparable[] a = {"B", "C", "A"};
        Comparable[] a = {2, 1, 3, 0, 4};
        show(a);
        sort(a);
        show(a);
        System.out.print(isSorted(a));
    }
}
