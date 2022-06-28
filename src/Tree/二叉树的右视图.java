package Tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的右视图 {
    static List<Integer> res=new ArrayList<>();

    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNode root) {

        return recursive(root);

    }
    //从root开始的右视图
    public static List<Integer> recursive(TreeNode root){
        if(root==null)
            return null;
        res.add(root.val);
        List<Integer> right=recursive(root.right);
        List<Integer> left=recursive(root.left);

        res.remove(res.size()-1);
        if(right!=null)
            res.addAll(right);
        else if(left!=null)
            res.addAll(recursive(root.left));
        return res;


    }
}
