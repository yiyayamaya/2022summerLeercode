package Amazon;

public class 天气预测 {
    public static void main(String[] args) {
        int []input=new int[]{6,-2,5};
        int []prefix=new int[input.length];
        int []suffix=new int[input.length];

        prefix[0]=input[0];
        for(int i=1;i<input.length;i++){
            prefix[i]+= prefix[i-1]+input[i];
            System.out.println("prefix[i] = " + prefix[i]);
        }


        for(int i=0;i<prefix.length;i++){
            suffix[i]=prefix[prefix.length-1]-prefix[i]+input[i];
            System.out.println("suffix[i] = " + suffix[i]);
        }

    }

}
