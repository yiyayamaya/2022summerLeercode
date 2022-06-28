import java.util.Arrays;

public class 三角形计数 {
    public static void main(String[] args) {
        triangleCount(new int[]{3,4,6,7});
    }

    public static int triangleCount(int[] s) {
        int res=0;
        Arrays.sort(s);
        for(int i=0;i<s.length;i++){
            for(int j=i+1;j<s.length;j++){
                int target=s[i]+s[j];
                int left=j+1;
                int right=s.length-1;
                //二分找第一个大于等于target的下标
                while(left<right){
                    int mid=left+(right-left)/2;
                    if(s[mid]>=target)
                        right=mid;
                    else
                        left=mid+1;
                }
                if(left<s.length&&s[left]>=target)
                    res+=left-1-j;
                else
                    res+=s.length-1-j;



            }
        }
        return res;
    }
}
