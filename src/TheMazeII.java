import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {
    static int n;
    static int m;
    static int [][]distance;
    public static void main(String[] args) {

        shortestDistance2(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}
        ,new int[]{0,4},new int[]{3,2});
    }

    public static int shortestDistance2(int[][] maze, int[] start, int[] destination) {

        n=maze.length;
        m=maze[0].length;
        distance=new int[n][m];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        return bfs(maze,start,destination);
    }


    public static int bfs(int[][] grid,int [] start, int[] destination) {




        Queue<int[]> queue=new LinkedList<>();

        queue.add(new int[]{start[0],start[1]});



        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int[] node = queue.remove();
            System.out.println(node[0]+" "+node[1]);
            for (int i = 0; i < 4; i++) {


                int x=node[0]+dx[i];
                int y=node[1]+dy[i];
                int count=0;
                while(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]!=1){
                    count++;
                    x+=dx[i];
                    y+=dy[i];
                }
                x=x-dx[i];
                y=y-dy[i];
                //第一次来还真不一定是最近
                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==0){
                    //这步移动的距离


                    distance[x][y]=Math.min(distance[x][y],distance[node[0]][node[1]]+count);

                    if(x==destination[0]&&y==destination[1])
                        return distance[x][y];
                    queue.add(new int[]{x,y});
                }
            }


        }

        return -1;

    }

    public static int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
        Queue< int[] > queue = new LinkedList< >();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
