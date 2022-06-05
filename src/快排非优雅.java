public class 快排非优雅 {
    public static void main(String[] args) {
        sortArray(new int[]{5,1,1,2,0,0});
    }


    public static int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public static void quickSort(int [] nums,int left,int right){
        if(left>=right)
            return;

        int x=left+(right-left+1)/2;
        int [] a=new int[right-left+1];
        int k1=0;
        int [] b=new int[right-left+1];
        int k2=0;

        int [] c=new int[right-left+1];
        int k3=0;
        for(int i=left;i<=right;i++){
            if(nums[i]<nums[x])
                a[k1++]=nums[i];
            else if(nums[i]==nums[x])
                b[k2++]=nums[i];
            else
                c[k3++]=nums[i];
        }

        for(int i=left;i<left+k1;i++){
            nums[i]=a[i-left];
        }

        for(int i=left+k1;i<left+k1+k2;i++){
            nums[i]=b[i-left-k1];
        }

        for(int i=left+k1+k2;i<left+k1+k2+k3;i++){
            nums[i]=c[i-left-k1-k2];
        }

        int v1 = left + k1 - 1;
        int v2 = left + k1;
        System.out.println();
        quickSort(nums,left,left+k1-1);
        quickSort(nums,left+k1,right);





    }
}
