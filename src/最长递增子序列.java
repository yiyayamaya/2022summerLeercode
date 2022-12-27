import java.util.Arrays;

public class 最长递增子序列 {
    public static void main(String[] args) {
        最长递增子序列 test = new 最长递增子序列();
        test.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println();
    }

    int[] nums;
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        return dfs(0);
    }

    //从numIndex走到end最长能有多长
    public int dfs(int numIndex) {
        if(memo[numIndex]!=-1)
            return memo[numIndex];


        int max = 0;
        for (int i = numIndex+1; i < nums.length; i++) {
            int res=dfs(i);
            //不能连同
            if (nums[i] <= nums[numIndex]) {
                max = Math.max(max, 1);
            }//能连通
            else {
                max = Math.max(max, res + 1);
            }
        }
        max = Math.max(max, 1);
       memo[numIndex]=max;
        return max;
    }
}
