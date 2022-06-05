public class 搜索旋转排序数组_soultion2 {

    public static void main(String[] args) {

        search(new int[]{5, 1, 3}, 2);


    }

    /***
     * mid分到左 mid分到右 应该是可以和找最左(第一个出现)/最右(最后一个出现)互推的， 可逆的。 也是二分法的第一步
     * 如果说采用哪个都可以 如33题 那就采用找最左就行了 当然找左也是完全可以的
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                if(target<=nums[mid]&&target>=nums[left]){
                    right=mid;
                }else{
                    left=mid+1;
                }

            }else{
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid;
                }

            }

        }



        if (target != nums[left]) {
            return -1;
        }


        return left;


    }


}
