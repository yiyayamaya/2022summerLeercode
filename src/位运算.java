public class 位运算 {
    public static void main(String[] args) {
        hammingWeight(10);
    }


    public static int hammingWeight(int n) {

        int res=0;
        while(n!=0){
            n=n-lowBit(n);
            System.out.println(n);
            res++;
        }
        return res;
    }

    public static int  lowBit( int x){
        return x&(~x+1);
    }
}
