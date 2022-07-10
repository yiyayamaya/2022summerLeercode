package DFS;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 删除无效的括号 {
    public static void main(String[] args) {
        删除无效的括号 test=new 删除无效的括号();
        //System.out.println(test.removeInvalidParentheses("()())()"));
        System.out.println(test.removeInvalidParentheses("(a)())()"));
    }
    int minDeleteCount;
    HashSet<String> res=new HashSet<>();
    String s;
    public List<String> removeInvalidParentheses(String s) {
        this.minDeleteCount=Integer.MAX_VALUE;
        this.s=s;
        dfs(0,0,0,0,s,0);

        return new ArrayList<>(res);
    }
    //index之前的左had 右had
    public void dfs(int leftHad,int rightHad,int letterHad, int index,String curString,int deleteCount){
         if(leftHad<rightHad)
             return;
        if(index==s.length()){
            if(leftHad==rightHad){
                if(deleteCount<minDeleteCount){
                    minDeleteCount=deleteCount;
                    res.clear();
                    curString=curString.replace(" ","");
                    res.add(curString);
                }else if(deleteCount==minDeleteCount){
                    curString=curString.replace(" ","");
                    res.add(curString);
                }
            }
            return;
        }
        StringBuilder sb=new StringBuilder(curString);
        sb.delete(index,index+1);

        //删当前
        char c=sb.charAt(index);
        sb.setCharAt(index,' ');
        dfs(leftHad,rightHad,letterHad,index+1,sb.toString(),deleteCount+1);
        sb.setCharAt(index,c);




        //不删当前
        if(c=='('){
            dfs(leftHad+1,rightHad,letterHad,index+1,sb.toString(),deleteCount);
        }else if(c==')'){
            dfs(leftHad,rightHad+1,letterHad,index+1,sb.toString(),deleteCount);
        }else{
            dfs(leftHad,rightHad,letterHad+1,index+1,sb.toString(),deleteCount);
        }


    }
}
