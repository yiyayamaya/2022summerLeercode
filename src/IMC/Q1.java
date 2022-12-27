package IMC;

import java.util.LinkedList;
import java.util.Queue;

public class Q1 {


    public static void main(String[] args) {
        Q1 q1=new Q1();
        System.out.println(q1.solution(1, 1, 4, 7, 6));
    }
    public String solution(int c, int x1, int y1, int x2, int y2) {
        //规定边界
        int m = x2;
        int n = y2;
        boolean[][] visited = new boolean[m+1][n+1];
        //bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1});
        visited[x1][y1] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            System.out.println("node[0]+node[1] = " + node[0] +" "+ node[1]);
            if(node[0]==x2&&node[1]==y2){
                return "YES";
            }
            // three directions
            int x = node[0] + c;
            int y = node[1] + c;
            if (x <= m && y <= n && !visited[x][y]) {
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
            x = node[0] + node[1];
            y = node[1];
            if (x <= m && y <= n && !visited[x][y]) {
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
            x = node[0];
            y = node[0] + node[1];
            if (x <= m && y <= n && !visited[x][y]) {
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }


        }
        return "NO";
    }
}
