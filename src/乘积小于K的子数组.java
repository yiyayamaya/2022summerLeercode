public class 乘积小于K的子数组 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK3(new int[]{1,2,3}, 0));
    }

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        //艹 连续子数组 太他妈简单了 check区间题和209最小差不多  找大等 所有组合-大等=小于
        int i = 0;
        int j = -1;
        int res = 0;
        int curProduct = 1;
        while (i < nums.length) {

            j=i;

            do {
                j++;
                curProduct = curProduct *nums[j];
            } while (curProduct < k &&(j<nums.length));


            if(curProduct>=k){
                res += nums.length - j+1;
                System.out.println(i+" "+(j-1)+" "+res);
            }


            curProduct=curProduct/nums[i];
            i++;
        }
        res = (nums.length + 1) * nums.length / 2 - res;
        return res;
    }

    public static int numSubarrayProductLessThanK3(int[] nums, int k) {
        //艹 连续子数组 太他妈简单了 check区间题和209最小差不多  找大等 所有组合-大等=小于
        int i = 0;
        int j = 0;
        int res = 0;
        int curProduct = 1;

        for(;j<nums.length;j++){
            curProduct=curProduct*nums[j];

            while(curProduct>=k&&i<nums.length){
                curProduct=curProduct/nums[i];
                i++;
            }
            if(i<=j)
                res+=j-i+1;


        }
        return res;




    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //艹 连续子数组 太他妈简单了 check区间题和209最小差不多  找大等 所有组合-大等=小于
        int i = 0;
        int j = 0;
        int res = 0;
        int curProduct = 1;
        while (i < nums.length) {
            j=i;
            while (curProduct< k&&j<nums.length) {
                curProduct = curProduct *nums[j];
                j++;

                //j溢出了怎么办
            }
            if(curProduct>=k){
                res += nums.length - j+1;
                System.out.println(i+" "+(j-1)+" "+res+" "+curProduct);
            }


            curProduct=curProduct/nums[i];
            i++;
        }
        res = (nums.length + 1) * nums.length / 2 - res;
        return res;
    }

}
