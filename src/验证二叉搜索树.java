public class 验证二叉搜索树 {
    public static void main(String[] args) {
      /*  TreeNode root = new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(6);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(7);*/
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(1);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(2);

        root.right=new TreeNode(5);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(6);
        isValidBST(root);

    }

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    public static boolean isValidBST(TreeNode root) {

        return recursive(root);
    }

    public static boolean recursive(TreeNode root ){
        if(root==null)
            return true;

        int leftMax=Integer.MAX_VALUE;
        int rightMin=Integer.MIN_VALUE;

        TreeNode nodeR=root.right;
        while(nodeR!=null){
            rightMin=nodeR.val;
            nodeR=nodeR.left;
        }
        TreeNode nodeL=root.left;
        while(nodeL!=null){
            leftMax=nodeL.val;
            nodeL=nodeL.right;
        }

        return leftMax<root.val&&rightMin>root.val&&recursive(root.left)&&recursive(root.right);
    }
    //一棵树的值都比某个数小
    public static boolean recursiceLeft(TreeNode root,int val){

        if(root.left!=null&&root.right!=null)
            return recursiceLeft(root.left,val)&&recursiceLeft(root.right,val);
        else if(root.left!=null)
            return recursiceLeft(root.left,val);
        else if(root.right!=null)
            return recursiceRight(root.right,val);
        else
            return root.val<val;

    }
    //一棵树的值都比某个数大
    public static boolean recursiceRight(TreeNode root,int val){
        if(root.left!=null&&root.right!=null)
            return recursiceLeft(root.left,val)&&recursiceLeft(root.right,val);
        else if(root.left!=null)
            return recursiceLeft(root.left,val);
        else if(root.right!=null)
            return recursiceRight(root.right,val);
        else
            return root.val>val;
    }
}
