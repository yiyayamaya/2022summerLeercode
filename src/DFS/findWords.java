package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class findWords {
    HashSet<String > res=new HashSet<>();
    char[][]board;
    int []dx=new int[]{0,1,-1,0};
    int []dy=new int[]{1,0,0,-1};
    boolean [][] visited;
    int m;
    int n;
    public static void main(String[] args) {
        findWords findWords1=new findWords();

        //char[][]board=new char[][]{ {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        //String []words=new String[]{"oath","pea","eat","rain"};
        char[][]board=new char[][]{ {'a','b','c','e'},{'x','x','c','d'},{'x','x','b','a'},{'i','f','l','v'}};
        String []words=new String[]{"abc","abcd"};

        findWords1.findWords(board,words);
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board=board;
        this.m=board.length;
        this.n=board[0].length;
        for(String word:words){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited=new boolean[m][n];
                    visited[i][j]=true;
                    dfs(i,j,0,word);
                }
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(int i,int j,int numIndex,String word){

        if(numIndex==word.length()-1&&word.charAt(numIndex)==board[i][j]){
            res.add(word);
            return;
        }
        //这个就不符合
        if (word.charAt(numIndex)!=board[i][j]) {
            return;
        }

        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<m&&y>=0&&y<n&&!visited[x][y]){
                visited[x][y]=true;
                dfs(x,y,numIndex+1,word);
                visited[x][y]=false;

            }
        }
    }
}
