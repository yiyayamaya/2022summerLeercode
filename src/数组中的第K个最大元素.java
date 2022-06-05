public class 数组中的第K个最大元素 {
    /**
     * 改进的快牌
     * @param args
     */
    public static void main(String[] args) {

        int k=4;
        int [] nums=new int []{5,2,4,1,3,6,0};
        k=nums.length-4;
        quickSort(nums,0,nums.length-1,k);

    }

    //[left right]中找一个数的索引 k是第k小
    public static int quickSort(int [] nums, int left, int right, int k){
        if(left>=right)
            return -99;
        int x=nums[left+(right-left)/2];

        int i=left-1;
        int j=right+1;
        while(i<j){
            do i++;while(nums[i]<x);
            do j--;while(nums[j]>x);
            if(i<j)
                swap(nums,i,j);
        }

        if(j==k)
            return quickSort(nums,left,j,k);
        else if(j<k)
            return quickSort(nums,j+1   ,right,k);
        else
            return quickSort(nums,left,j,k);


    }

    public static void swap(int [] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
