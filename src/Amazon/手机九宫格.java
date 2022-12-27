package Amazon;

import java.util.*;

public class 手机九宫格 {
    public static void main(String[] args) {
        String input="abacadefghibj";
        HashMap<Character,Integer> hashMap=new HashMap<>();//Character
        char[] arr = input.toCharArray();
        for(char c:arr){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }


        for(int i=0;i<26;i++){
            char c=(char)('a'+i);
            if(!hashMap.containsKey(c))
                hashMap.put(c,0);
        }


        ArrayList<Map.Entry<Character, Integer>> list=new ArrayList<>(hashMap.entrySet());

        Collections.sort(list,new Comparator <Map.Entry<Character,Integer>>(){

            @Override
            public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
                return o2.getValue()-o1.getValue();
            }

        });

        String []res=new String[9];
        Arrays.fill(res,"");
        int k=0;
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character,Integer> entry:list){

            res[count]=res[count]+entry.getKey();
            count++;
            count=count%9;
        }

        for (String s : res) {
            System.out.println(s);
        }


    }
}
