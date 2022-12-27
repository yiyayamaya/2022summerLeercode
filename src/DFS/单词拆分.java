package DFS;

import java.util.*;

public class 单词拆分 {
    public static void main(String[] args) {
        单词拆分 test = new 单词拆分();
        String s = "leetcode";
        List<String> list = List.of(new String[]{"leet", "code"});
        System.out.println(test.wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        HashSet<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if ((j - 1 < 0 && wordSet.contains(s.substring(j, i + 1)))
                        || (j - 1 >= 0 && dp[j - 1] && wordSet.contains(s.substring(j, i + 1)))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
