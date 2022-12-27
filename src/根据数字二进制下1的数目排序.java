import java.util.*;

public class 根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        long res=64;
        long base=1;
        while(res!=0){
            long cur=res%2;
            if(cur!=0)
                System.out.println(base+" "+cur);
            res=res/2;
            base=base*2;
        }
       // System.out.println(cur);
    }
}
