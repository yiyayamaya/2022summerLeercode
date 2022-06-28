import java.util.*;

public class 单词接龙 {
    public static void main(String[] args) {
        List<String> wordList=new ArrayList<>();
  /*      wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        ladderLength("hit","cog",wordList);*/

/*        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        ladderLength("a","c",wordList);*/

        wordList.add("abo");
        wordList.add("hco");
        wordList.add("hbw");
        wordList.add("ado");
        wordList.add("abq");
        wordList.add("hcd");

        wordList.add("hcj");
        wordList.add("hww");
        wordList.add("qbq");
        wordList.add("qby");
        wordList.add("qbz");
        wordList.add("abo");

        wordList.add("qbx");
        wordList.add("qbw");
        ladderLength("hbo","qbx",wordList);


    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int res=0;
        HashMap<String,ArrayList<String>> adjacentMap=new HashMap<>();
        for(int i=0;i<wordList.size();i++)
            adjacentMap.put(wordList.get(i),new ArrayList<String>());

        for(int i=0;i<wordList.size();i++){
            for(int j=i;j<wordList.size();j++){
                String s1=wordList.get(i);
                String s2=wordList.get(j);
                if(check(s1,s2)){
                    //只差一个字母 是一条临边
                    adjacentMap.get(s1).add(s2);
                    adjacentMap.get(s2).add(s1);
                }
            }
        }
        HashSet<String> visited=new HashSet<>();
        Queue<String> queue=new LinkedList<>();

        boolean found=false;
        //找到一个能作为起点的
        //beginWord在wordList里面
        for (String s : wordList) {

            if(beginWord.equals(s)){
                res=0;
                queue.add(s);
                visited.add(s);
                found=true;
                break;
            }
        }
        //beginWord不在wordList里面 多源头找
        if (!found) {
            for (String s : wordList) {
                if (check(beginWord, s)) {
                    res = 1;
                    queue.add(s);
                    visited.add(s);
                    if(s.equals(endWord))
                        return 2;
                    break;

                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String node=queue.remove();
                ArrayList<String> adjacentStrings = adjacentMap.get(node);
                for (String adjacentString : adjacentStrings) {
                    if (!visited.contains(adjacentString)) {
                        if(adjacentString.equals(endWord))
                            return res+1;
                        visited.add(adjacentString);
                        queue.add(adjacentString);
                    }
                }
            }
        }


        return 0;


    }

    //检查两个字符串是否差一个字母 true=是
    public static boolean check(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i))
                count++;
        }
        return count==s1.length()-1;
    }
}
