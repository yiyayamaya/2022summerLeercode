package DP;

import java.util.Arrays;
import java.util.HashSet;

public class 最长公共子序列 {
    public static void main(String[] args) {
        最长公共子序列 test = new 最长公共子序列();
        String s = "yby";
        String t = "bl";
        System.out.println(test.longestCommonSubsequence(s, t));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        int [][]dp=new int[m][n];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-99);
        //找到第一个相同的点设为1




        if(text1.charAt(0)==text2.charAt(0))
            dp[0][0]=1;

        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0];
            if(text1.charAt(i)==text2.charAt(0))
                dp[i][0]=1;
        }

        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1];
            if(text1.charAt(0)==text2.charAt(j))
                dp[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){

                if(text1.charAt(i)==text2.charAt(j))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];

    }

}
