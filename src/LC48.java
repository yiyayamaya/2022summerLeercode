public class LC48 {
    public static void main(String[] args) {
        LC48 lc48=new LC48();
        int [][] matrix=new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7}};
        lc48.rotate(matrix);
    }
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]res=new int[n][m];
        //m=3 n=4
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int y=m-1-i;
                int x=j;
                res[x][y]=matrix[i][j];
            }
        }
        for (int[] ints : res) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

}
