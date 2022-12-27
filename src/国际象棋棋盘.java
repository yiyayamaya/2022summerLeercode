public class 国际象棋棋盘 {
    public static void main(String[] args) {
        int N=5;
        char[][]res=new char[N][N];
        boolean nextIsW=true;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(nextIsW){
                    res[i][j]='W';
                }else{
                    res[i][j]='B';
                }
                nextIsW=!nextIsW;
            }
        }

        System.out.println();
    }
}
