import java.util.*;

public class test {


    public static void main(String[] args) {

        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();

        occurrences.put(1,100);
        occurrences.put(2,99);
        occurrences.put(3,120);

        Set<Map.Entry<Integer, Integer>> entries = occurrences.entrySet();
        int [] nums=new int[occurrences.size()];
        int k=0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            nums[k++]=entry.getValue();
        }

        System.out.println();

    }
}
