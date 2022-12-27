package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class maxStockPrice {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,2,2,2,3,2,2,2,2,4};
        int k = 3;
        maxStockPrice test = new maxStockPrice();
        //System.out.println(test.solution1(input, k));
        System.out.println(test.solutionMy(new int[]{1,2,2,2,2,3,2,2,2,2,4}, 3));
        System.out.println(test.solutionMy(new int[]{1,2,7,7,4,3,6}, 3));
        System.out.println(test.solutionMy(new int[]{1,2,7,7,4,3}, 3));
        System.out.println(test.solutionMy(new int[]{1,2,1,1,4,3,6}, 2));
        System.out.println(test.solutionMy(new int[]{1,2,2,1,4,3,6}, 3));
        System.out.println(test.solutionMy(new int[]{1,1,1,1,1,1,1}, 4));

        //System.out.println(test.solution4(input, k));

    }
    public int solutionMy(int []arr,int k){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int left=0;
        int right=0;
        int curSum=0;
        int maxSum=0;
        for(;right<arr.length;right++){
            if(hashMap.containsKey(arr[right])){
                if(hashMap.get(arr[right])>=left){
                    int newLeft=hashMap.get(arr[right])+1;
                    for(int i=left;i<newLeft;i++){
                        System.out.println(i+"是要被删除的");
                        curSum-=arr[i];
                    }
                    left=newLeft;
                }
            }
            hashMap.put(arr[right],right);
            curSum+=arr[right];
            if(right-left+1>k){
                curSum-=arr[left];
                left++;
            }
            if(right-left+1==k){
                maxSum=Math.max(maxSum,curSum);
                System.out.printf("[%d,%d]\n",left,right);
            }
        }
        return maxSum;
    }

    /**
     * 大神写的 代码我看不懂
     * @param arr
     * @param k
     * @return
     */
    public int solution2(int[] arr, int k) {
        //所有数字上次出现位置
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        int kSum = 0;
        int left = -1;
        for (int right = 0; right < arr.length; right++) {
            int num = arr[right];
            if (hashMap.containsKey(num) && hashMap.get(num) > left) {
                left = hashMap.get(num);
            }
            hashMap.put(num, right);
            kSum += num;
            if (right >= k) {
                kSum -= arr[right - k];
            }
            if (right - k >= left) {
                ans = Math.max(ans, kSum);
                System.out.printf("[%d,%d]\n",left,right);
            }
        }
        return ans;

    }




    /**
     * 大概是对的  应该基于这个优化
     * @param stocks
     * @param k
     * @return
     */
    public int solution4(int[] stocks, int k) {
        int res = 0, start = 0, count = 0, cur = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < stocks.length; i++) {
            if (map.containsKey(stocks[i])) {
                int finalStart = map.get(stocks[i]);
                while (start <= finalStart) {
                    cur -= stocks[start];
                    map.remove(stocks[start]);
                    count--;
                    start++;
                }
            }
            if (count < k) {
                cur += stocks[i];
                count++;
                map.put(stocks[i], i);
                if (count == k) {
                    res = Math.max(res, cur);
                }
            } else {
                cur += stocks[i] - stocks[start];
                map.put(stocks[i], i);
                map.remove(stocks[start]);
                start++;
                res = Math.max(res, cur);
            }
        }
        return res;
    }


    /***
     * 复杂度太高了 可能过不了所有case
     * @param
     * @param
     * @return
     */
    public int solution1(int[] input, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxSum = 0;
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += input[i];
            hashMap.put(input[i], hashMap.getOrDefault(input[i], 0) + 1);
            //todo 更新left 把旧left到新left全删掉
        }
        if (hashMap.size() == k) {
            maxSum = Math.max(maxSum, curSum);
        }

        for (int i = k; i < input.length; i++) {
            int left = i - k;
            hashMap.put(input[left], hashMap.get(input[left]) - 1);
            if (hashMap.get(input[left]) == 0) {
                hashMap.remove(input[left]);
            }
            curSum -= input[left];
            int right = i;
            hashMap.put(input[right], hashMap.getOrDefault(input[right], 0) + 1);
            curSum += input[right];
            if (hashMap.size() == k) {
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }
}
