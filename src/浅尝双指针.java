public class 浅尝双指针 {
    public static void main(String[] args) {
        String s="apple Ben Cat";
        int n=s.length();
        for(int i=0;i<n;i++){

            int j=i;
            while(j<n&&s.charAt(j)!=' '){
                j++;
            }
            System.out.println(s.substring(i,j));
            i=j;
        }
    }
}
