package DFS;

import java.util.ArrayList;
import java.util.List;

public class 单词拆分II {
     ArrayList<String> res=new ArrayList<>();
     List<String> wordDict;
    public static void main(String[] args) {
        单词拆分II test=new 单词拆分II();
        ArrayList<String> wordDict=new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(test.wordBreak("catsanddog", wordDict));

    }
    public  List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict=wordDict;
        dfs(s,"");
        return res;

    }
    public  void dfs(String s, String curPath){


        for(String word:wordDict){
            int i=0;
            int j=0;
            while(i<s.length()&&j<word.length()&&s.charAt(i)==word.charAt(j)){
                i++;
                j++;
            }
            if(i==s.length()&&j==word.length()){
                curPath+=word;
                res.add(curPath);
            }
            else if(j==word.length()){
                curPath+=word+" ";
                dfs(s.substring(i),curPath);
            }


        }

    }
}
