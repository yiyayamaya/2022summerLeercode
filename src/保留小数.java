import java.text.DecimalFormat;

public class 保留小数 {
    public static void main(String[] args) {
        double f = 1;

        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println(df.format(f));


    }
}
