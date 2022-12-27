package Amazon;

public class SearchWord {
    public static void main(String[] args) {
        String searchWord="armaze";
        String resultWord="amazon";
        int i=0;
        int j=0;
        while(i<searchWord.length()&&j<resultWord.length()){
            if(searchWord.charAt(i)==resultWord.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        int res=resultWord.length()-j;
        System.out.println(res);
    }
}
