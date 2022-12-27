package BelvedereTrading;

public class 水电计价问题 {
    public static void main(String[] args) {
        //接下来的100度=1 接下来的150度=2 接下来的100度=3
        String s="1";
        int[][] input = {new int[]{10, 1}, new int[]{10, 2},  new int[]{10, 3},new int[]{5, 4}};
        //当前遍历到input的第几个了
        int inputIndex=0;
        int currentUpper=input[inputIndex][0];
        int []res=new int[100000];
        for (int count = 1; count <= 100000; count++) {
//            System.out.println(count+" "+currentUpper+" "+input[inputIndex][1]);
            res[count]=input[inputIndex][1];
            if(count==currentUpper){
                inputIndex+=1;
                if (inputIndex<input.length)
                    currentUpper+=input[inputIndex][0];
                else
                    break;
            }

        }

        for (int i = 1; i < res.length; i++) {
            if(res[i]!=0)
                System.out.println(i + " " + res[i]);
        }

    }
}
