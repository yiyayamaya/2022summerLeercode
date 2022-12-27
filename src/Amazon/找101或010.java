package Amazon;

public class 找101或010 {
    public static void main(String[] args) {
        numberOfWays("001101");
    }

    public static long numberOfWays(String s) {
        int n = s.length();
        long ans = 0;
        char[] ss = s.toCharArray();
        int[] pz = new int[n];
        int[] po = new int[n];
        int z = 0, o = 0;
        for (int i = 1; i < n; i++) {
            if (ss[i - 1] == '0') {
                z++;
                pz[i] = z;
                po[i] = o;
            } else if (ss[i - 1] == '1') {
                o++;
                po[i] = o;
                pz[i] = z;
            }
        }
        z += ss[n - 1] - '0' > 0 ? 0 : 1;
        o += ss[n - 1] - '0' > 0 ? 1 : 0;

        for (int i = 1; i <= n - 2; i++) {
            if (ss[i] == '0') ans += po[i] * (o - po[i]);
            else ans += pz[i] * (z - pz[i]);
        }
        return ans;
    }
}
