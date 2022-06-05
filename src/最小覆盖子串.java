import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 最小覆盖子串 {
    public static void main(String[] args) {


        System.out.println(minWindow("a", "b"));

    }

    public static String minWindow(String s, String t) {

        //目标map
        HashMap<Character,Integer> targetMap=new HashMap<>();
        HashMap<Character,Integer> curMap=new HashMap<>();


        for(char c:t.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }




        //存的是{0,2,4}关键字母的位置
        ArrayList<Integer> al=new ArrayList<>();

        int i=0;
        int j=0;


        int min=Integer.MAX_VALUE;
        String res="";




        while(j<s.length()||check(curMap,targetMap)){
            //满了 i要+了
            if(curMap.size()==targetMap.size()&&check(curMap,targetMap)){

                while(curMap.size()==targetMap.size()&&check(curMap,targetMap)){
                    if(j-i<min){
                        min=j-i;
                        res=s.substring(i,j);
                    }
                    if(curMap.containsKey(s.charAt(i))){
                        curMap.put(s.charAt(i),curMap.get(s.charAt(i))-1);

                    }


                    i++;
                }











            }
            //没满继续加
            else{
                //j动直到满足
                while(j<s.length()&&!     (curMap.size()==targetMap.size()&&check(curMap,targetMap))     ){
                    if(targetMap.containsKey(s.charAt(j)))
                        curMap.put(s.charAt(j), curMap.getOrDefault(s.charAt(j), 0) + 1);
                    j++;

                }



            }

        }


        return res;

    }



    //检查s用curMap能否拼出一个t
    public static boolean check(HashMap<Character,Integer> curMap,HashMap<Character,Integer> targetMap){


        for (Character key : targetMap.keySet()) {
            if(!curMap.containsKey(key))
                return false;
            if(curMap.get(key)<targetMap.get(key))
                return false;
        }
        return true;


    }
}
