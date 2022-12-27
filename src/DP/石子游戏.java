package DP;

import java.util.Arrays;
import java.util.HashSet;

public class 石子游戏 {
    public static void main(String[] args) {
        石子游戏 test = new 石子游戏();
        int[] piles = new int[] { 5,3,4,5 };
        System.out.println(test.stoneGame(piles));
    }
    public boolean stoneGame(int[] piles) {
        int [][]dp=new int[piles.length][piles.length];
        for(int i=0;i<piles.length;i++)
            Arrays.fill(dp[i],-99);
        int sum=0;
        for (int value : piles) {
            sum += value;
        }
        boolean b = dfs(dp, piles, 0, piles.length - 1) > sum / 2;
        return true;
    }
    //从[i,j]中 alice 能取得的max total
    public int dfs(int [][]dp,int []piles,int l,int r){
        if(l>r)
            return 0;

        if(dp[l][r]!=-99)
            return dp[l][r];
        boolean even=((r-l)%2)==0;
        int left=0;
        int right=0;
        if(even){
            left=piles[l];
            right=piles[r];
        }
        dp[l][r]=Math.max(left+dfs(dp,piles,l+1,r),right+dfs(dp,piles,l,r-1));
        return dp[l][r];


    }

}
