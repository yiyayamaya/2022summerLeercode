public class 颜色分类 {
    public static void main(String[] args) {


        sortColors(new int []{2,0,2,1,1,0});
    }

    public static void sortColors(int[] nums) {

        int left=0;
        int right=nums.length-1;
        int i=0;
        //这个=
        while(i<=right){
            if(nums[i]==1)
                i++;
            else if(nums[i]==0){
                swap(nums,left,i);
                left++;
                //跟0换过来的一定是1 一定不会是2不会是0 所以可以i++
                //i++;
            }else if(nums[i]==2){
                swap(nums,right,i);
                right--;
                //核心在这里不i++ 换完后重新判断i的成分
            }
        }

    }

        public static void swap(int []nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
}
