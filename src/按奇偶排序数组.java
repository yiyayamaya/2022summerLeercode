import java.util.ArrayList;

public class 按奇偶排序数组 {
    public static void main(String[] args) {
        int[] nums=new int[]{3,1,2,4};
        int[] res=new int[nums.length];



        int left=0;
        int right=nums.length-1;

        for (int num : nums) {
            if (num%2==0) {
                res[left]=num;
                left++;
            }else{
                res[right]=num;
                right--;
            }


        }













    }
}
