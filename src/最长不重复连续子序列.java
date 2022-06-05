import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class 最长不重复连续子序列 {
    public static void main(String[] args) {
        String s="12235";


        int n=s.length();
        int max=0;
        //int arr []=new int[n];
        HashMap<Character,Integer> map = new HashMap<>();
        //i终点 j起点 固定i 移动j
        for(int i=0,j=0;i<n;i++){



            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); //如果没有放入则设为0


            while(map.get(s.charAt(i))>1){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                j++;

            }


            max=Math.max(max,i-j+1);

        }

        System.out.println(max);
    }

    //是否有重复元素
    public static boolean check(int j,int i,String s){
        char[] chars = s.substring(j,i+1).toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        for (char aChar : chars) {
            if (hashSet.contains(aChar)) {
                return true;
            }
            hashSet.add(aChar);

        }
        return false;

    }


}
