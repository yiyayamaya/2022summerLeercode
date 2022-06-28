public class 打印菱形 {
    public static void main(String[] args) {
        int n =5;

        for (int i = 0; i <n; i++) {
            for (int i1 = 0; i1 < n - i; i1++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int i1 = 0; i1 < i; i1++) {
                System.out.print("**");
            }
            System.out.println();
        }
        for (int i = n; i >=0; i--) {
            for (int i1 = 0; i1 < n - i; i1++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int i1 = 0; i1 < i; i1++) {
                System.out.print("**");
            }
            System.out.println();
        }
    }
}
