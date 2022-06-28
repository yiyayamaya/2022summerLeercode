import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {
    public static void main(String[] args) {

        //orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
        orangesRotting(new int[][]{{0}});
    }

    public static int orangesRotting(int[][] grid) {
        //初始好橘子数量
        int goodNum=0;
        //minute0 以后新增坏橘子数量
        int badNum=0;
        int minutes=0;

        int n=grid.length;
        int m=grid[0].length;

        int [][]visited=new int[n][m];


        Queue< int[]> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=1;
                }else if(grid[i][j]==1)
                    goodNum++;
            }
        }

        int []dx=new int []{-1,0,1,0};
        int []dy=new int []{0,-1,0,1};

        while(!queue.isEmpty()){
            //类似于层序遍历 一次while对应一层
            int size=queue.size();
            minutes++;
            //这一层要吐出来的 一起吐
            for(int a=0;a<size;a++){
                int[] node=queue.poll();
                for(int i=0;i<4;i++){
                    int x=node[0]+dx[i];
                    int y=node[1]+dy[i];
                    if(x>=0&&x<n&&y>=0&&y<m&&visited[x][y]==0&&grid[x][y]==1){
                        badNum++;
                        queue.offer(new int[]{x,y});
                        visited[x][y]=1;
                        grid[x][y]=2;
                    }
                }
            }

        }

        if(badNum==goodNum)
            return minutes;
        return -1;

    }
}
