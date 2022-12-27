package Amazon;

public class netStockMonth {
    public static void main(String[] args) {
        int []input=new int[]{1,3,2,4,5};
        int n= input.length;
        int []prefix=new int[n];
        int []suffix=new int[n];
        prefix[0]=input[0];
        for(int i=1;i< n;i++){
            prefix[i]= prefix[i-1]+input[i-1];
        }

        suffix[n - 1] = input[n - 1];




        for(int i=0;i< input.length-1;i++){
            int leftStart=0;
            int leftEnd=i;
            int rightStart=i+1;
            int rightEnd= input.length-1;
            int avg1=prefix[leftEnd+1]-prefix[leftStart];
            avg1=avg1/(i+1);
            int avg2=prefix[rightEnd+1]-prefix[rightStart];
            avg2=avg2/(input.length-(i+1));
            System.out.println("leftStart+\" \"+leftEnd+\" \"+rightStart+\" \"+rightEnd = " +
                    leftStart + " " + leftEnd + " " + rightStart + " " + rightEnd+
                    " "+avg1+" "+avg2);
        }
    }
}
