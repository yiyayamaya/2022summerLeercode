package BelvedereTrading;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        List<List<Integer>> input=new ArrayList<>();
        input.add(Arrays.asList(1, 2000, 5, 1));
        input.add(Arrays.asList(1, 2030, 15, 2));
        input.add(Arrays.asList(1, 2000, 10, 1));
        input.add(Arrays.asList(2, 2050, 15, 5));
        input.add(Arrays.asList(1, 2067, 8, 6));
        input.add(Arrays.asList(2, 2050, 5, 7));

/*        input.add(Arrays.asList(1, 2000, 5, 1));
        input.add(Arrays.asList(2, 2050, 15, 2));*/

/*
        input.add(Arrays.asList(1, 2000, 5, 2));
        input.add(Arrays.asList(1, 2050, 5, 4));
*/

/*        input.add(Arrays.asList(1, 2000, 5, 3));
        input.add(Arrays.asList(1, 2040, 5, 2))*/;




        Q1Solution(input);

    }

    public static void Q1Solution(List<List<Integer>> input){
        int curSequenceNumber=0;
        //key: [M,Q]
        HashMap<Integer,double[]> map=new HashMap<>();
        for (int i=0;i<input.size();i++){
            List<Integer> item = input.get(i);
            if(item.get(3)<curSequenceNumber){
                System.out.println();
                continue;
            }else{
                curSequenceNumber=item.get(3);
                double [] M_Q = map.getOrDefault(item.get(0), new double[]{0, 0});
                double M1=(M_Q[0]*M_Q[1]+item.get(1)*item.get(2))/(M_Q[1]+ item.get(2));
                DecimalFormat df = new DecimalFormat("0.00");
                M1=Math.round(M1 * 100)/100.00;
                String format = df.format(M1);
                System.out.println(item.get(0)+" "+format);
                map.put(item.get(0),new double[]{M1,(M_Q[1]+ item.get(2))});
            }
        }
    }



}
