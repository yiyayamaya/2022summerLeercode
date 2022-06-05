public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        search(new int[]{1}, 0);
    }

    /**
     * 神中神写法 可以套红绿区间check模板
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target >= nums[left]) {
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] <= target && nums[mid] >= nums[0])
                    left = mid;
                else
                    right = mid - 1;
            }
        } else {
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target && nums[mid] <= nums[nums.length - 1])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        if (target != nums[left]) {
            return -1;
        }
        return left;
    }
    

}
