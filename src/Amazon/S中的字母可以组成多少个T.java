package Amazon;

public class S中的字母可以组成多少个T {
    public static void main(String[] args) {
        String s="mononom";
        String t="mon";
        int []sCount=new int[26];
        int []tCount=new int[26];
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int indexS=0;
        int indexT=0;
        for (char c : arrS) {
            sCount[c-'a']++;
        }
        for (char c : arrT) {
            tCount[c-'a']++;
        }

        int res=Integer.MAX_VALUE;
        for (int i=0;i<26;i++) {
            if(tCount[i]==0)
                continue;
            int i1 = sCount[i] / tCount[i];
            res=Math.min(res,i1);
        }

        System.out.println(res);

    }
}
