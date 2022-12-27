package Amazon;

public class 工程师最低最高 {
    public static void main(String[] args) {
        int []input=new int[]{1, 2, 3, 4, 4, 5};
        int left=0;
        int right=input.length-1;
        while(left<right){
            double tmp=((double)input[left]+input[right])/2;
            System.out.println("tmp = " + tmp);
            left++;
            right--;
        }

    }
}
