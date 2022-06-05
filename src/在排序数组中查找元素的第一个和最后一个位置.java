

public class 在排序数组中查找元素的第一个和最后一个位置 {

    /***
     * 此类问题 我与模板有两处不同
     * 1.我是 right = mid - 1;   right = mid - 1;  模板是 right = mid; right = mid;模板步子小 我步子大
     * 2. findLast我是左中点+补丁 模板是右中点 免补丁
     * 第二点我姑且臣服 第一点我的大步子会有出界问题 但也可以通过while结束后的if避免 请看findFirst里面两行的todo
     * @param args
     */
    public static void main(String[] args) {

        searchRange(new int[]{2, 2}, 3);

    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast2(nums, target);

        return new int[]{first, last};

    }


    public static int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                //todo 模板这里是right=mid 还正确 我这么写会出界 为什么看不出来影响呢 因为此时只有right出界了 left尚未出界
                // 下面的则为 left出界了 right尚未出界 也就是说我把while结束的If判断right 是否可以坚持我的写法？ 我草 还真是！！！！！！!
                right = mid - 1;
            } else if (nums[mid] < target) {
                //mid+1再次有个right顶着 不会出界
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (target != nums[left]) {
            return -1;
        }
        return left;
    }


    /***
     * todo 按照模板改进成右中点 但是有一处仍无法共识
     * @param nums
     * @param target
     * @return
     */
    public static int findLast2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                //todo 这里和模板无法达成共识 我草我懂了 虽然模板步子迈的小 但是可以保证不出界 如果这里达成共识 下一个todo就可以去掉了！！！！！！！！！ 此处值得研究一天
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;

            }
        }


        if (target != nums[right]) {
            return -1;
        }
        return left;
    }

    public static int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                //todo 这里和模板无法达成共识
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
                if (right - left == 1) {
                    if (nums[right] == target) {
                        return right;
                    }
                    if (target != nums[left]) {
                        return -1;
                    }
                    return left;
                }
            }
        }

        if (target != nums[left]) {
            return -1;
        }
        return left;
    }
}
