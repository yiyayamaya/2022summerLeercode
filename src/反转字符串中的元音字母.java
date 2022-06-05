public class 反转字符串中的元音字母 {

    public static void main(String[] args) {
        reverseVowels("hello");
    }
    public static String reverseVowels(String s) {

        int length=s.length();

        char[] res=s.toCharArray();

        int i=0;
        int j=length-1;

        while(i<j){

            for(;i<j;){
                if(!check(s.charAt(i)))
                    i++;
                else
                    break;
            }

            for(;j>i;){
                if(!check(s.charAt(j)))
                    j--;
                else
                    break;
            }



            if(check(s.charAt(i)) &&check(s.charAt(j))){
                swap(res,i,j);
                i++;
                j--;

            }
        }

        return new String(res);

    }

    public static boolean check(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
            return true;
        return false;
    }

    public static void swap (char [] res,int i,int j){
        char tmp=res[i];
        res[i]=res[j];
        res[j]=tmp;
    }
}
