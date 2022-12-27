package Amazon;

public class 删掉k个连续数组 {
    public static void main(String[] args) {
        int []arr=new int []{7,3,6,1};
        int k=2;
        int max=0;
        int curSum=0;

        for(int i=0;i<arr.length;i++){
            curSum+=arr[i];
            if(i==k-1){
                max=Math.max(max,curSum);
            }
            if(i>=k){
                curSum-=arr[i-k];
                max=Math.max(max,curSum);
            }

        }
        System.out.println(max);
    }
}
