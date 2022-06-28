public class 根据前序和后序遍历构造二叉树 {
    public static void main(String[] args) {

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return recursive(preorder,postorder,0,preorder.length-1,0,preorder.length-1);

    }

    static TreeNode  recursive(int []preorder,int [] postorder,int preStart,int preEnd,int postStart, int postEnd){

        if(preStart>preEnd)
            return null;

        if(preStart==preEnd)
            return new TreeNode(preorder[preStart]);

        //假设遇到的第一堆一定是左 如果还有第二堆就是右
        int leftRoot=preorder[preStart+1];
        //左右子树的长度
        int leftSize=0;
        int rightSize=0;

        for(int i=postStart;i<=postEnd;i++){
            leftSize++;
            if(postorder[i]==leftRoot){
                break;
            }

        }

        rightSize=preEnd-preStart-leftSize;




        int rootVal=preorder[preStart];
        TreeNode root=new TreeNode(rootVal);




        int preStart1=preStart+1;
        int preEnd1=preStart1+leftSize-1;
        int postStart1=postStart;
        int postEnd1=postStart1+leftSize-1;
        root.left=recursive(preorder,postorder,preStart1,preEnd1,postStart1,postEnd1);

        int preEnd2=preEnd;
        int preStart2=preEnd2-rightSize+1;
        int postEnd2=postEnd-1;
        int postStart2=postEnd2-rightSize+1;
        root.right=recursive(preorder,postorder,preStart2,preEnd2,postStart2,postEnd2);

        return root;
    }
}
