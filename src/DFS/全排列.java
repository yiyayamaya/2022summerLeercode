package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 全排列 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

        全排列 test = new 全排列();
        int[] candidates = {1, 2, 3};
        System.out.println(test.permute(candidates));
    }

    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(i, nums, new ArrayList<>(), new HashSet<Integer>());

        }
        return res;
    }

    public void dfs(int numIndex, int[] nums, List<Integer> curPath, HashSet<Integer> hashSet) {

        if (numIndex == nums.length)
            return;
        if (curPath.size() == nums.length) {
            res.add(new ArrayList<>(curPath));
            return;
        }
        if (hashSet.contains(numIndex))
            return;


        curPath.add(nums[numIndex]);
        hashSet.add(numIndex);
        if(curPath.size()==nums.length){
            res.add(new ArrayList<>(curPath));
            hashSet.remove(numIndex);
            curPath.remove(curPath.size() - 1);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(i, nums, curPath, hashSet);
        }
        hashSet.remove(numIndex);
        curPath.remove(curPath.size() - 1);



    }
}
