package DP;

public class 解码方法 {
    public static void main(String[] args) {
        解码方法 test = new 解码方法();
        String s = "12";
        System.out.println(test.numDecodings(s));
    }
    public int numDecodings(String s) {
        int []dp=new int [s.length()+1];
        dp[0]=0;
        //dp[i]是s[i-1]位
        for(int i=1;i<=s.length();i++){
            char preChar;
            char curChar=s.charAt(i-1);
            int curNum=Character.getNumericValue(curChar);
            if(!(curNum>=1&&curNum<=9))
                dp[i]--;
            if(i-2>=0){
                int preCurNum=Integer.parseInt(s.substring(i-2,i));
                if(preCurNum>=10&&preCurNum<=26)
                    dp[i]++;
            }
            dp[i]+=dp[i-1];


        }
        return dp[s.length()];
    }
}
