public class 数组中的最长山脉 {
    public static void main(String[] args) {
        longestMountain(new int[]{2,3,3,2,0,2});
    }

    public static int longestMountain(int[] arr) {

        int i=0;
        int j=1;


        boolean started=false;
        boolean arrived=false;
        int max=0;
        while(j<arr.length){

            if(arr[j]==arr[j-1]){
                if(arrived)
                    max=Math.max(j-i,max);
                i=j;
                started=false;
            }else if (arr[j]>arr[j-1]){
                if(!started){
                    i=j-1;
                    started=true;
                    j++;
                    continue;

                }
                if(arrived){
                    System.out.println(i+" "+j);
                    max=Math.max(j-i,max);
                    i=j-1;
                    arrived=false;
                }else{

                }
            }else {
                if(started){
                    if(arrived){

                    }else{
                        arrived=true;
                    }
                }

            }
            j++;


        }
        if(arrived)
            max=Math.max(j-i,max);

        return max;

    }
}
