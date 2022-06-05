public class 验证回文字符串Ⅱ {

    public static void main(String[] args) {
        validPalindrome("abc");
    }
    public static boolean validPalindrome(String s) {

        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return check(s.substring(i,j-1+1))||check(s.substring(i+1,j+1));
            }

        }

        return true;

    }

    public static boolean check(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
