package two3211;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Q1 {


        public static void main(String[] args) throws Exception {
            String str="$bo*y gi!r#l";
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(!Character.isLetter(str.charAt(i))){
                    str.replace(str.charAt(i)+""," ");
                }

            }

            String[] s=str.split(" ");

            for(int i=s.length-1;i>=0;i--){
                System.out.print(s[i]+" ");
            }


    }
}
