import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.print("");
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        for(int num:nums)
            System.out.print(num+" ");

        System.out.println();

        HashSet<Integer> hashSet1=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(hashSet1.contains(nums[i])){
                continue;
            }
            hashSet1.add(nums[i]);
            List<Integer> cur =new ArrayList<>();
            HashSet<Integer> hashSet=new HashSet<>();
            cur.add(nums[i]);
            int target=-nums[i];
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                //System.out.println(left+" "+right);
                if(nums[left]+nums[right]>target)
                    right--;
                else if(nums[left]+nums[right]<target)
                    left++;
                else{
                    //System.out.println(nums[left]+" "+nums[right]+" "+hashSet.size());
                    if(!hashSet.contains(nums[left])){

                        hashSet.add(nums[left]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        res.add(cur);
                        cur =new ArrayList<>();
                        cur.add(nums[i]);
                    }
                    left++;
                }
            }
        }
        return res;
    }
}
