package Amazon;

public class CommonPrefix {
    public static void main(String[] args) {
        String s="abcabcdabcae";
        System.out.println(commonPrefix(s));
    }

    public static int commonPrefix(String input) {
        int n = input.length();
        if(n == 0) return 0;

        int res = n;
        char[] arr = input.toCharArray();
        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[0]){
                int tmp=getPrefixLength(arr, i);
                System.out.println(tmp);
                res += tmp;
            }

        }

        return res;
    }

    public static int getPrefixLength(char[] arr, int start) {
        int res = 0, i = 0, j = start;

        while(j < arr.length) {
            if(arr[i++] == arr[j++])
                res++;
            else
                break;
        }
        return res;
    }
}
