package Amazon;

public class 被4或2整除 {
    public static void main(String[] args) {
        int []input=new int[]{4,5,6};
        int res=0;
        for (int i : input) {
            if(i%2==0){
                int count=i/2;
                int tmp=count/2+1;
                System.out.println(tmp);
            }
        }

        //System.out.println(res);
    }
}
