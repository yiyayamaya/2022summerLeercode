import java.util.concurrent.ThreadLocalRandom;

public class debug技巧 {
    public static void main(String[] args) {

        try {
            int a = 1 / 0;

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }


    }


}
