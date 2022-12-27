package DP;

public class 不同路径II {
    public static void main(String[] args) {
        不同路径II test = new 不同路径II();
        int[][] obstacleGrid = new int[][] { { 0, 1 }, { 0, 0 } };
        System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp=new int[m][n];
        dp[0][0]=1;
        for(int j=1;j<n;j++){
            if(obstacleGrid[0][j]!=1)
                dp[0][j]=dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]!=1)
                dp[i][0]=dp[i-1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }

            }
        }
       return dp[m-1][n-1];

    }
}
