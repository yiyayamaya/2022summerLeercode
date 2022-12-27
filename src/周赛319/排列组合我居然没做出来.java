package 周赛319;

import java.util.ArrayList;
import java.util.List;

public class 排列组合我居然没做出来 {

    static int[] input = new int[]{1,2,3,4};
    static int length;
    static List<List<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        length=input.length;
        dfs2(0,new ArrayList<>());
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    //子集
    static void dfs(int curIndex, List<Integer> curPath) {
        if(curPath.size()>=2){
            res.add(new ArrayList<>(curPath));
        }
        for(int i=curIndex;i<length;i++){
            curPath.add(input[i]);
            dfs(i+1,curPath);
            curPath.remove(curPath.size()-1);
        }
    }

    //连续子数组
    static void dfs2(int curIndex, List<Integer> curPath) {

        res.add(new ArrayList<>(curPath));


        for(int i=curIndex;i<length;i++){
            curPath.add(input[i]);
            dfs(i+1,curPath);
            curPath.remove(curPath.size()-1);
        }


        int i=curIndex;
        if(curIndex<length){
            //加一个
            curPath.add(input[i]);
            dfs2(i+1,curPath);
            curPath.remove(curPath.size()-1);

            //不加
            dfs2(length,curPath);
        }





    }
}
