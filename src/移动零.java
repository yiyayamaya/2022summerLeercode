public class 移动零 {

    public static void moveZeroes(int[] nums) {
        //下一个需要被給数的位置
        int i=0;
        int j=0;
        while(j<nums.length){
            while(nums[j]==0){
                j++;
                if(j==nums.length){
                    while(i<nums.length){
                        nums[i]=0;
                        i++;
                    }
                    return;
                }

            }
            nums[i]=nums[j];
            i++;
            j++;
        }

        while(i<nums.length){
            nums[i]=0;
            i++;
        }
    }

    public static void main(String[] args) {

        moveZeroes( new  int[]{0,1,0});
    }
}
