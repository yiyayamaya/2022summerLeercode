package Amazon;

import java.util.ArrayList;

public class String操作 {
    public static void main(String[] args) {
        String strMsg    = "An?Example!of.String|11";
        String delims  = "[delimiters]+";
        String[] tokenString = strMsg.split("\\.|\\||!|\\?");
        ArrayList<String> list=new ArrayList<>();
        String.join("",list);
        for (String s : tokenString) {
            System.out.println("s = " + s);
        }
    }
}
