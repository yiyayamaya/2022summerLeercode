package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 递增子序列 {
    public static void main(String[] args) {
        递增子序列 test=new 递增子序列();
        int [] candidates={100,90,80,70,60,50,60,70,80,90,100};
        System.out.println(test.findSubsequences(candidates));
    }
    int k;
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        for(int k=2;k<=nums.length;k++){
            this.k=k;
            dfs(nums,0,new ArrayList<Integer>(),new HashSet<Integer>());

        }

        return res;
    }

    public void dfs(int []nums,int numIndex,ArrayList<Integer> curPath,HashSet<Integer> hashSet){
        if(numIndex==nums.length)
            return;

        if(hashSet.contains(nums[numIndex])){
            dfs(nums,numIndex+1,curPath,hashSet);
            return;
        }


        //路线/邻居node1  加了0 立刻计入本轮影响 然后进下一轮 这里也应该有一个sum==target的判断 但是可以省略
        //无路线 再也不能有更多的numIndex数了 但是之前加进来的就无所谓



        hashSet.add(nums[numIndex]);
        dfs(nums,numIndex+1,curPath,hashSet);
        hashSet.remove(nums[numIndex]);

        if(curPath.size()!=0&&nums[numIndex]<curPath.get(curPath.size()-1)){
            dfs(nums,numIndex+1,curPath,hashSet);

        }else{
            dfs(nums,numIndex+1,curPath,hashSet);

            curPath.add(nums[numIndex]);
            if(curPath.size()==k){
                res.add(new ArrayList<Integer>(curPath));
                curPath.remove(curPath.size()-1);
                return;
            }
            //邻居2
            dfs(nums,numIndex+1,curPath,hashSet);
            curPath.remove(curPath.size()-1);
        }













    }
}
