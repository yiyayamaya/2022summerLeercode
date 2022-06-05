import java.util.ArrayList;

public class 我原来不懂快排 {
    public static void main(String[] args) {

        //int [] nums=new int []{4,2,3,6,5};
        int [] nums=new int []{5,2,3,1};

        quickSort(nums,0,nums.length-1);
        System.out.println();
    }

    public static void quickSort(int [] nums,int left,int right){

        if(left>=right)
            return;
        int p=left+(right-left)/2;
        int pivot=nums[p];
        int i=left;
        int j=left;


        for(;j<=right;j++){
            if(nums[j]<=pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,p);
        System.out.println();


        quickSort(nums,left,i-1);

        quickSort(nums,i+1,right);





    }

    public static void swap(int [] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public int[] toIntArr( ArrayList<Integer> al){


        int res[]=new int [al.size()];
        int k=0;
        for(int a:al){
            res[k++]=a;
        }

        return res;
    }
}
