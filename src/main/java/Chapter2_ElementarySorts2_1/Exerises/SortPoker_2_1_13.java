package Chapter2_ElementarySorts2_1.Exerises;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiao on 2017/1/3.
 */
public class SortPoker_2_1_13 {
    private List<String> poker = new ArrayList<String>();

    SortPoker_2_1_13(){
        poker.add("heitao");
        poker.add("hongtao");
        poker.add("meihua");
        poker.add("fangpian");
    }

    private boolean less(String i, String j){
        return poker.indexOf(i) - poker.indexOf(j) < 0;
    }

    private void sort(String[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j > 0 && j < a.length; j--) {
                if(less(a[j], a[j-1])){
//                    exch(a, j-1, j);
                }
            }
        }
    }

//    public void

}
