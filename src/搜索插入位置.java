public class 搜索插入位置 {
    public static void main(String[] args) {
        int res=searchInsert(new int[]{1,3},0);
    }

    public static int searchInsert(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=(left+right)/2;
            if (nums[mid]>=target) {
                right=mid;
            }else{
                left= mid+1;
            }
        }



        return left;
    }
}
