package Chapter2_ElementarySorts2_1.Exerises;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxiao on 2017/1/3.
 */
public class SortPoker_2_1_13{
    private List<String> poker;

    SortPoker_2_1_13(){
        poker = new ArrayList<String>();
        poker.add("heitao");
        poker.add("hongtao");
        poker.add("meihua");
        poker.add("fangpian");
    }

    private boolean less(String i, String j){
        return poker.indexOf(i) - poker.indexOf(j) < 0;
    }

    private void sort(List<String> a){
        for (int i = 0; i < a.size(); i++) {
            for (int j = i; j > 0 && less(a.get(j), a.get(j-1)); j--) {
                exch(a, j-1, j);
            }
        }
    }

    public static void exch(List<String> pokerList, int i, int j){
        String temp = pokerList.get(i);
        pokerList.set(i, pokerList.get(j));
        pokerList.set(j, temp);
    }

    public static void show(List<String> pokerList){
        System.out.println(pokerList);
    }

    public  boolean isSorted(List<String> a){
        for (int i = 1; i < a.size(); i++) {
            if(less(a.get(i), a.get(i-1))){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testPokerSort(){
        String[] poker = {"fangpian", "hongtao", "heitao", "fangpian", "meihua"};
        List pokerList = Arrays.asList(poker);
        show(pokerList);
        sort(pokerList);
        show(pokerList);
        System.out.print(isSorted(pokerList));
    }

}
