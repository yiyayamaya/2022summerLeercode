public class 字符串分割 {
    public static void main(String[] args) {

        String str = "5+2-64*36+25/65";
        String[] array = str.split("\\+|-|\\*|/");
        for (String s : array) {
            System.out.println("s = " + s);
        }

    }
}
