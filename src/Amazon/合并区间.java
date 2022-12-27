package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 5}, {4, 5}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] interval : intervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> res=new ArrayList<>();

        for (int[] interval : intervals) {

            if (interval[0] > end) {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else
                end = Math.max(end, interval[1]);
        }

    }
}
