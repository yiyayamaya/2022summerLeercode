public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
       // buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        buildTree(new int[]{1,2},new int[]{1,2});
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return recursive(preorder,inorder,0,preorder.length-1,0,preorder.length-1);

    }
    static TreeNode  recursive(int []preorder,int [] inorder,int preStart,int preEnd,int inStart, int inEnd){

        if(preStart>preEnd||preStart<0)
            return null;


        int rootVal=preorder[preStart];

        //左右子树的长度
        int leftSize=0;
        int rightSize=0;

        TreeNode root=new TreeNode(rootVal);

        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                break;
            }
            leftSize++;
        }
        rightSize=preEnd-preStart-leftSize;

        int preStart1=preStart+1;
        int preEnd1=preStart1+leftSize-1;
        int inStart1=inStart;
        int inEnd1=inStart1+leftSize-1;
        root.left=recursive(preorder,inorder,preStart1,preEnd1,inStart1,inEnd1);

        int preEnd2=preEnd;
        int preStart2=preEnd2-rightSize+1;
        int inEnd2=inEnd;
        int inStart2=inEnd2-rightSize+1;
        root.right=recursive(preorder,inorder,preStart2,preEnd2,inStart2,inEnd2);

        return root;
    }
}
