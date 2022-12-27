package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 学习PriorityQueue {
    static int[] arr = new int[]{5, 20, 40, 20, 2, 1};
    //static int[] arr = new int[]{5,  40, 20, 2, 1};

    public static void main(String[] args) {

        //小根堆 维护最大的两个
        小根不优化();
        System.out.println();
        小根优化后();
        System.out.println();
        //大根堆 维护最大的两个
        q2();

    }

    /**
     * 小根堆 未优化 维护最大的2个
     */
    static void 小根不优化() {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : arr) {
            if (heap.size() >= 2) {
                heap.add(num);
                heap.poll();
            } else {
                heap.add(num);
            }
        }
        int smallest = heap.peek();
        for (int num : arr) {
            if (num < smallest)
                System.out.println(num);
        }
    }

    /**
     * 小根堆 优化 维护最大的2个
     */
    static void 小根优化后() {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : arr) {
            if (heap.size() >= 2) {
                if(num>heap.peek()){
                    heap.add(num);
                    heap.poll();
                }
            } else {
                heap.add(num);
            }
        }
        int smallest = heap.peek();
        for (int num : arr) {
            if (num < smallest)
                System.out.println(num);
        }
    }

    /**
     * 大根堆维护最大的2个
     */
    static void q2() {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : arr) {
            if (heap.size() >= 2) {
                heap.add(num);
                heap.poll();


            } else {
                heap.add(num);
            }
        }
        int smallest = heap.peek();
        for (int num : arr) {
            if (num < smallest)
                System.out.println(num);
        }
    }
}
