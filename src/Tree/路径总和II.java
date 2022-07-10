package Tree;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II {
    public static void main(String[] args) {
        路径总和II test = new 路径总和II();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(test.pathSum(root, 12));



    }
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recursive(root,targetSum,new ArrayList<Integer>());
        return res;
    }

    //递归效果 找到所有路径
    public void recursive(TreeNode root,int targetSum,List<Integer>curPath){
        if(root==null)
            return;

        if(root.left==null&&root.right==null&&root.val==targetSum){
            res.add(new ArrayList<Integer>(curPath));
            //我自己层的我得自己收拾好 这里明明走对了 也要收拾么？是的 你得保证回到上一层时候是走之前的状态
            return;
        }
        //从这里开始这一层 本层计入 sum curPath
        curPath.add(root.val);
        //下一层 的一步 走下去到头行了 记录下来了 or走下去到头了还不行 删除了。 所以下面层走的都在他们那层收拾好了 我这层不用用管
        recursive(root.left,targetSum-root.val,curPath);
        recursive(root.right,targetSum-root.val,curPath);

        //我自己层的我得自己收拾好
        curPath.remove(curPath.size()-1);


    }
}
