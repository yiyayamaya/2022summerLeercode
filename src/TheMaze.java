import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    static int n;
    static int m;
    static int[][] visited;


    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {

        n=maze.length;
        m=maze[0].length;
        visited=new int[n][m];

        return bfs(maze,start,destination);
    }
    public static void main(String[] args) {
        hasPath(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}},new int[]{0,4},new int[]{4,4});


    }
    public static boolean bfs(int[][] grid,int [] start, int[] destination) {




        Queue<int[]> queue=new LinkedList<>();

        queue.add(new int[]{start[0],start[1]});
        visited[start[0]][start[1]]=1;



        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int[] node = queue.remove();
            for (int i = 0; i < 4; i++) {
                int x=node[0];
                int y=node[1];
                while(dx[i]!=0&&x+dx[i]>=0&&x+dx[i]<n&&grid[x+dx[i]][y]!=1)
                    x+=dx[i];
                while(dy[i]!=0&&y+dy[i]>=0&&y+dy[i]<m&&grid[x][y+dy[i]]!=1)
                    y+=dy[i];

                ;

                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==0&&visited[x][y]==0){
                    if(x==destination[0]&&y==destination[1])
                        return true;
                    visited[x][y]=1;
                    queue.add(new int[]{x,y});
                }
            }


        }
        return false;

    }
}
