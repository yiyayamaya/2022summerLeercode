import java.util.LinkedList;
import java.util.Queue;

public class 走迷宫 {


    public static void main(String[] args) {
        int[][] puzzle = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0}};

        System.out.println(bfs(puzzle));

    }

    public static int bfs(int[][] puzzle) {

        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        int m=puzzle.length;
        int n=puzzle[0].length;
        //走到这需要几步
        int[][] steps=new int[m][n];
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < steps[i].length; j++) {
                steps[i][j]=-1;
            }
        }

        Queue<int[]> queue=new LinkedList<>();

        steps[0][0]=0;
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] node = queue.remove();
            for (int i = 0; i < 4; i++) {
                int x=node[0]+dx[i];
                int y=node[1]+dy[i];
                if(x>=0&&x<m&&y>=0&&y<n&&puzzle[x][y]==0&&steps[x][y]==-1){
                    steps[x][y]=steps[node[0]][node[1]]+1;
                    queue.add(new int[]{x,y});
                }
            }


        }
        return steps[m - 1][n - 1];
    }


}
