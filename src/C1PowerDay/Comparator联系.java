package C1PowerDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class c1 implements Comparator<Stock1>{

    @Override
    public int compare(Stock1 stock1, Stock1 t1) {
        return (int) (stock1.value-t1.value);
    }
}
public class Comparator联系 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("aaa");
        Collections.sort(list);

        ArrayList<Stock1> list2=new ArrayList<>();
        Collections.sort(list2, new Comparator<Stock1>() {
            @Override
            public int compare(Stock1 stock1, Stock1 t1) {
                return (int) (stock1.value-t1.value);
            }
        });
    }

}
