package Tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的右视图 {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(4);
        rightSideView(root);

    }

    public static List<Integer> rightSideView(TreeNode root) {

        return recursive(root);

    }
    //从root开始的右视图
    public static List<Integer> recursive(TreeNode root){
        if(root==null)
            return null;
        List<Integer> res=new ArrayList<>();
        res.add(root.val);
        List<Integer> right=recursive(root.right);
        List<Integer> left=recursive(root.left);

        if(right!=null)
            res.addAll(right);
        else if(left!=null)
            res.addAll(recursive(root.left));
        return res;


    }
}
