import java.util.Arrays;

public class 接雨水 {
    public static void main(String[] args) {
        int[] arr = new int[]{0};

        trap(arr);
    }


    public static int trap(int[] height) {

        int max = Arrays.stream(height).max().getAsInt();
        int length = height.length;

        int sum = 0;
        //count 代表第几层
        for (int count = 0; count < max; count++) {
            int i = 0;
            int j = 0;
            boolean started = false;
            boolean leftWall = false;


            for (; j < length; j++) {

                //如果是墙
                if (height[j] > count) {
                    leftWall = true;
                    //是墙没开始 则一段新开始
                    if (!started) {

                        //是墙已经开始 一段结束
                    } else {
                        sum += j - i - 1;
                        System.out.println(count + " " + i + " " + j + " =" + (j - i - 1));
                        started = false;
                    }
                }
                //如果是水
                else {

                    if (leftWall) {
                        if (!started) {

                            i = j - 1;
                            started = true;
                        }
                    }


                }
            }
        }

        return sum;


    }
}
