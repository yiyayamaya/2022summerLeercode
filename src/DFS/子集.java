package DFS;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    public static void main(String[] args) {

        子集 test=new 子集();
        int [] nums={1,2,3};
        System.out.println(test.subsets(nums));

    }
    int k;
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.k=3;
        dfs(nums,0,new ArrayList<Integer>());
        // for(int k=1;k<=nums.length;k++){
        //     this.k=k;
        //     System.out.println(k);
        //     dfs(nums,0,new ArrayList<Integer>());
        // }
        return res;
    }

    public void dfs(int []nums,int numIndex,ArrayList<Integer> curPath){
        if(numIndex==nums.length)
            return;
        //却一个return
        // if(curPath.size()>=k)
        //     return;
        //当前层 计入

        curPath.add(nums[numIndex]);
        System.out.println(curPath.toString());
        if(curPath.size()==k){
            res.add(new ArrayList<>(curPath));
            curPath.remove(curPath.size()-1);
            return;
        }
        for(int i=numIndex+1;i<numIndex;i++){
            dfs(nums,i,curPath);
        }
        curPath.remove(curPath.size()-1);


    }

}
