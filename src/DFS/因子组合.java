package DFS;

import java.util.ArrayList;
import java.util.List;

public class 因子组合 {
    List<List<Integer>> res=new ArrayList<>();
    int n;
    public List<List<Integer>> getFactors(int n) {
        this.n=n;
        dfs(2,n,new ArrayList<Integer>());
        return res;
    }

   public void dfs(int num,int sum,ArrayList<Integer> curPath){


        if(sum==1){
            res.add(new ArrayList<>(curPath));
            return;
        }


        for(int i=num;i<n;i++){
            if(sum%i!=0||i>sum)
                continue;
            curPath.add(i);
            dfs(i,sum/i,curPath);
            curPath.remove(curPath.size()-1);
        }



    }
    public static void main(String[] args) {
        因子组合 test=new 因子组合();
        System.out.println(test.getFactors(23848713));

    }
}
