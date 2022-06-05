public class 有效的完全平方数 {
    public static void main(String[] args) {


        isPerfectSquare(104976);
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //这里是假的大 但是其实无妨
            if (mid > num / mid) {
                right = mid - 1;
                //这里是真的小
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                if (num % mid == 0) {
                    return true;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (num / left == left) {
            if (num % left == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
