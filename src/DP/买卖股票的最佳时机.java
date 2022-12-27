package DP;

import java.util.Arrays;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        买卖股票的最佳时机 test = new 买卖股票的最佳时机();
        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 5, 4, 3, 2};
        System.out.println(test.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int res=0;

        int n=prices.length;
        //从开始到当前i的最低
        int [] buy=new int[n];
        //从i到结束的最高
        int [] sell=new int[n];
        Arrays.fill(buy,Integer.MAX_VALUE);
        Arrays.fill(sell,Integer.MIN_VALUE);
        buy[0]=prices[0];
        sell[n-1]=prices[n-1];

        for(int i=1;i<n;i++){
            buy[i]=Math.min(buy[i-1],prices[i]);
        }

        for(int i=n-2;i>=0;i--){
            sell[i]=Math.max(sell[i+1],prices[i]);
        }

        for(int i=0;i<n;i++){
            res=Math.max(res,sell[i]-buy[i]);
        }
        return res;
    }
}
