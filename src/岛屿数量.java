import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    static int n;
    static int m;
    static int[][] steps;
    public static void main(String[] args) {
        int res=0;
        int[][] map = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        n=map.length;
        m=map[0].length;
        steps=new int[n][m];
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < steps[i].length; j++) {
                steps[i][j]=-1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]==1&&steps[i][j]==-1) {
                    bfs(map,new int[]{i,j});
                    res++;
                }
            }
        }
        System.out.println(res);

    }

    public static void bfs(int[][] puzzle,int [] start) {

        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};


        Queue<int[]> queue=new LinkedList<>();

        steps[0][0]=0;
        queue.add(new int[]{start[0],start[1]});

        while(!queue.isEmpty()){
            int[] node = queue.remove();
            for (int i = 0; i < 4; i++) {
                int x=node[0]+dx[i];
                int y=node[1]+dy[i];
                if(x>=0&&x<n&&y>=0&&y<m&&puzzle[x][y]==1&&steps[x][y]==-1){
                    steps[x][y]=steps[node[0]][node[1]]+1;
                    queue.add(new int[]{x,y});
                }
            }


        }

    }
}
