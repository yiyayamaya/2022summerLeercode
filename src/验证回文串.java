public class 验证回文串 {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){

            while( !isLetter(s.charAt(i)) &&i<j)
                i++;
            while( !isLetter(s.charAt(j)) &&i<j)
                j--;

            if(check(s.charAt(i),s.charAt(j))){
                i++;
                j--;
            }else
                return false;


        }

        return true;

    }


    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    public static boolean check(char c, char C) {
        if(c==C)
            return true;
        if(   (c >= 'a' && c <= 'z') && (C >= 'A' && C <= 'Z')  )
            return c==C+32;
        if( (C >= 'a' && C <= 'z') && (c >= 'A' && c <= 'Z') )
            return C==c+32;
        return false;
    }
}
