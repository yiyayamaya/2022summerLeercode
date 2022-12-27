package two3211;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 迷宫 {
    int m;
    int n;
    int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    int [][]maze;
    boolean[][] visited;
    ArrayList<ArrayList<String>> res=new ArrayList<>();
    public static void main(String[] args) {

        int maze[][] = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0}
        };
        迷宫 test=new 迷宫();
        test.solution(maze);


    }

    public void solution(int [][]maze){
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];
        this.maze=maze;
        visited[0][0]=true;
        dfs(0,0,new ArrayList<>());

        System.out.println(res);

    }

    public void dfs(int i, int j, ArrayList<String> curPath) {
        if (i == m - 1 && j == n - 1) {
            res.add(new ArrayList<>(curPath));
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<n&&y>=0&&y<m&&maze[x][y]==0&&!visited[x][y]){
                visited[i][j]=true;
                curPath.add(x+" "+y);
                dfs(x,y,curPath);
                curPath.remove(curPath.size()-1);
                visited[i][j]=false;
            }
        }
    }
}
