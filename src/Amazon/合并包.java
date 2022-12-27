package Amazon;

public class 合并包 {
    public static void main(String[] args) {
        int [] a=new int[]{30,15,5,9};
        int n=a.length;
        int []b=new int[a.length];
        b[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--){ // start traversing from the last.
            if(a[i]<b[i+1]){ // if condition is true then merge.
                b[i]=b[i+1]+a[i];
            }
            else
                b[i]=a[i]; // otherwise ignore and copy same from given array.

            for(int num:b)
                System.out.print(num+" ");
            System.out.println();

        }
        for(int i=n-2;i>=0;i--){
            if(a[i]<a[i+1])
                a[i]=a[i]+a[i+1];

            for(int num:a)
                System.out.print(num+" ");
            System.out.println();
        }
    }
}
