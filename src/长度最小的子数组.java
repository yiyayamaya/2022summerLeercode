public class 长度最小的子数组 {
    public static void main(String[] args) {

        System.out.println(minSubArrayLen3(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    public static int minSubArrayLen3(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;


        for(;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=target&&i<=j){
                sum=sum-nums[i];
                i++;
            }
            //i追上j了还不满足
            System.out.println(i+" "+j);

            //此时[i,j]已经不满足[i-1,j]是满足的最短的

            min=Math.min(min,j-(i-1)+1);


        }


        return min;

    }

    public static int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }



    public static int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;


        while(j<nums.length||sum>=target){
            if(sum<target){
                sum+=nums[j];
                j++;
            }else{
                min=Math.min(min,j-i);
                sum-=nums[i];
                i++;
            }
        }
        if(min==Integer.MAX_VALUE)
            return 0;

        return min;

    }
}
