public class 山脉数组的峰顶索引 {
    public static void main(String[] args) {



        peakIndexInMountainArray(new int[]{3,4,5,1});
    }

    public static int peakIndexInMountainArray(int[] arr) {


        int left=0;
        int right=arr.length-1;
        while(right-left>1){
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1]){
                left=mid;
            }else if(arr[mid]<arr[mid-1]&&arr[mid]>arr[mid+1]){
                right=mid;
            }else{
                return mid;
            }
        }

        return -99;


    }
}
