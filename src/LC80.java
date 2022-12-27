public class LC80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            int count = 0;
            int lastInt = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (fast == 0) {
                    count = 1;
                    lastInt = nums[0];
                    //System.out.println(fast+" "+nums[fast]);
                    nums[slow++] = nums[fast];
                } else {
                    if (nums[fast] == lastInt) {
                        count++;
                        if (count <= 2) {
                            //System.out.println(fast+" "+nums[fast]);
                            nums[slow++] = nums[fast];
                        }
                    } else {
                        count = 1;
                        lastInt = nums[fast];
                        nums[slow++] = nums[fast];
                        //System.out.println(fast+" "+nums[fast]);
                    }
                }
            }
            return slow;
        }
    }
}
