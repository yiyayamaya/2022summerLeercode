package DP;

public class 最长回文子串 {
    public static void main(String[] args) {
        最长回文子串 test = new 最长回文子串();
        String s = "cbbd";
        System.out.println(test.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int res = 0;
        int resI=-1;
        int resJ=-1;
        int n = s.length();
        //longest palindrome found in [i,j]

        boolean dp[][] = new boolean[n][n];
        //dps 存ij位置
        int dps[][][] = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            int j=i;
            dp[i][j] = true;
            res=j+1-i;
            resI=i;
            resJ=j;
        }
        for(int i=0;i<=n-2;i++){
            int j=i+1;
            if(s.charAt(i)==s.charAt(j)){
                dp[i][j]=true;
                res=j+1-i;
                resI=i;
                resJ=j;
            }
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if(j+1-i>res){
                        res=j+1-i;
                        resI=i;
                        resJ=j;
                    }
                }

            }
        }
        return s.substring(resI, resJ+1);
    }
}
