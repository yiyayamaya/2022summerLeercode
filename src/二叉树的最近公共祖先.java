public class 二叉树的最近公共祖先 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        lowestCommonAncestor(root, root.left, root.right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        if(recursice1(root,p)&&recursice1(root,q)){
            if(root.val==p.val)
                return p;
            if(root.val==q.val)
                return q;
            if(recursice1(root.left,p)&&recursice1(root.left,q))
                return lowestCommonAncestor(root.left,p,q);
            if(recursice1(root.right,p)&&recursice1(root.right,q))
                return lowestCommonAncestor(root.right,p,q);
            return root;
        }


        return null;
    }

    //给我一个节点是不是p的祖先
    public static boolean recursice1(TreeNode root,TreeNode p){
        if(root==null)
            return false;
        if(root.val==p.val)
            return true;
        return recursice1(root.left,p)||recursice1(root.right,p);
    }
}
