package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {

    List<List<String>> res=new ArrayList<>();
    int n;
    //竖 y=x y=-x
    int[] col;
    int[] dg;
    int[] udg;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        col=new int[n];
        dg=new int[4*n-1];
        udg=new int[4*n-1];

        dfs(0,new int[n][n]);
        return res;
    }
    //一行一行来
    public void dfs(int line,int [][]nums){


        if(line==n){
            List<String> board = generateBoard(nums, n);
            res.add(board);
            return;
        }


            for(int j=0;j<n;j++){
                if(col[j]==1||dg[line+j]==1||udg[n+j-line]==1)
                    continue;
                nums[line][j]=1;
                col[j]=1;
                dg[line+j]=1;
                udg[n+j-line]=1;
                dfs(line+1,nums);
                nums[line][j]=0;
                col[j]=0;
                dg[line+j]=0;
                udg[n+j-line]=0;
            }






    }
    public List<String> generateBoard(int[] []nums, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());

        }
        return board;
    }
    public static void main(String[] args) {
        N皇后 test=new N皇后();
        System.out.println(test.solveNQueens(4));
    }
}
