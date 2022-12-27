package Tree;

public class getDigitsSum {
    public static void main(String[] args) {
        int X=20;
        int Y=5;
        int res=0;

        for (int i = 0; i < X; i++) {
            if(get(i)==Y){
                res++;
                System.out.println("i = " + i);
            }
        }
        System.out.println(res);

    }
    public static int get(int num){
        int res=0;
        while(num!=0){
            res+=num%10;
            num=num/10;
        }
        return res;
    }
}
