import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _01矩阵 {
    static int n;
    static int m;
    static int [][]matGlobal;
    static int [][]visted;
    static int [][]distance;
    public static void main(String[] args) {
        //int[][]mat=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][]mat=new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        updateMatrix(mat);
    }

    public static int[][] updateMatrix(int[][] mat) {

        //1找0 不好 太慢 0往1扩散

        matGlobal=mat;
        n=mat.length;
        m=mat[0].length;
        distance=new int[n][m];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        visted=new int[n][m];


        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)
                    bfs(new int[]{i,j});

            }
        }

        return distance;


    }

    public static void bfs(int [] start) {




        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{start[0],start[1]});
        distance[start[0]][start[1]]=0;
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int[] node = queue.remove();


            for (int i = 0; i < 4; i++) {
                int x=node[0]+dx[i];
                int y=node[1]+dy[i];
                //只有1才需要入队 0不需要
                if(x>=0&&x<n&&y>=0&&y<m&&matGlobal[x][y]==1){
                    if(distance[node[0]][node[1]]+1<distance[x][y]){
                        queue.add(new int[]{x,y});
                        distance[x][y]=distance[node[0]][node[1]]+1;
                    }

                }


            }
        }


    }
}
