package Amazon;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;

public class 买小说 {
    public static void main(String[] args) {

        //每日新到
        int [] newCome=new int[]{1,3,2,4,5};
        //小明最新想买
        int need=1;
        //书店库存
        HashSet<Integer> hashSet=new HashSet<>();
        for(int book: newCome){
            hashSet.add(book);
            ArrayList<Integer> tmp=new ArrayList<>();
            if(book==need){
                tmp.add(need);
                need++;
                while(hashSet.contains(need)){
                    tmp.add(need);
                    need++;
                }
            }else{
                tmp.add(-1);
            }
            System.out.println("tmp = " + tmp);
        }


    }
}
