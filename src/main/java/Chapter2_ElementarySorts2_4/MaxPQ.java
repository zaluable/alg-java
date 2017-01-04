package Chapter2_ElementarySorts2_4;

/**
 * Created by zhangxiao3 on 2017/1/4.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private int N =0;
    private Key[] pq;

    MaxPQ(int maxN){
        pq = (Key[])new Comparable[maxN+1];
    }
    MaxPQ(Key[] a){
        N = a.length;
    }
    public void Insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key max(){
        return pq[1];
    }

    public Key delMax(){
        Key max = pq[1];
        exch(pq, N, 1);
        pq[N--] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
    public int size(){
        return N;
    }

    private void sink(int k){
        while(k <= N){
            int j = 2*k;
            if(j > N && less(j,j+1)){
                j++;
            }
            if(!less(k, j)){
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private void swim(int k){
//        while(k > 1){
//            int j = k/2;
//            if(less(j, k)){
//                exch(a, j, k);
//            }
//            k = j;
//        }
        while(k > 1 && less(k/2, k)){
            exch(pq, k/2, k);
        }
        k = 2/k;
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

}
