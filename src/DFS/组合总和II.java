package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 组合总和II {
    List<List<Integer>> res=new ArrayList<>();
    int [] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates=candidates;
        this.target=target;

        dfs(0,0,new ArrayList<>(),new HashSet<>());


        return res;
    }

    public void dfs(int numIndex,int sum,ArrayList<Integer> curPath,HashSet<Integer> hashSet){

        if(sum==target){
            res.add(new ArrayList<>(curPath));
            System.out.println(curPath.toString());

            return;
        }
        if(sum>target)
            return;
        if(numIndex==candidates.length)
            return;


        if(hashSet.contains(candidates[numIndex])){
            dfs(numIndex+1,sum,curPath,hashSet);
            return;

        }



        //路线/邻居node1  啥也不加 立刻计入sum curPath影响  下一轮再计入res影响
        hashSet.add(candidates[numIndex]);
        dfs(numIndex+1,sum,curPath,hashSet);
        hashSet.remove(candidates[numIndex]);


        //路线/邻居node2 加了自己 立刻计入sum curPath影响  下一轮再计入res影响
            curPath.add(candidates[numIndex]);
            dfs(numIndex+1,sum+candidates[numIndex],curPath,hashSet);
            curPath.remove(curPath.size()-1);



    }

    public static void main(String[] args) {
        组合总和II test=new 组合总和II();
        int [] candidates={10,1,2,7,6,1,5};
        System.out.println(test.combinationSum2(candidates,8));
        System.out.println();
    }
}
